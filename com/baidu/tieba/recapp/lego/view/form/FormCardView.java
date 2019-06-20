package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.d;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.a.b;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.baidu.tieba.recapp.r;
import com.baidu.ubc.UBC;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private int cHc;
    private LinearLayout iDA;
    private LinearLayout iDB;
    private ImageView iDC;
    private TextView iDD;
    private TextView iDE;
    private FormCard iDF;
    private List<a> iDG;
    private String iDH;
    private float iDI;
    private int iDJ;
    private TitleView iDy;
    private CommitView iDz;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean cfn();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iDH = "";
        this.mScreenWidth = 0;
        this.cHc = 0;
        this.iDI = 1.0f;
        this.iDJ = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bHO() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.iDy = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.iDC = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.iDC.setEnabled(false);
        this.iDz = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.iDB = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.iDA = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.iDD = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.iDE = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.iDz != null) {
            this.iDz.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.iDG, FormCardView.this.iDz.getPostUrl(), FormCardView.this.iDH);
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(FormCard formCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(FormCard formCard) {
        if (formCard != null && formCard.mIsLegal && this.iDF != formCard) {
            cfu();
            this.iDF = formCard;
            this.iDH = formCard.getItemId();
            ck(formCard.mWidth, formCard.mHeight);
            this.iDy.aP(this.iDI);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iDy.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iDI);
            }
            this.iDz.aP(this.iDI);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iDz.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iDI);
            }
            this.iDy.a(formCard.titleInfo);
            this.iDz.a(formCard.commitInfo);
            b.ceN().a(new com.baidu.tieba.recapp.a.a(this.iDz.getPostUrl()));
            cfr();
            cft();
            cfs();
            a(this.iDy);
            a(this.iDz);
            if (formCard.isCommitSuccess()) {
                cfv();
            }
            if (!formCard.mHasShown) {
                r.ceM().ceI().ck(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void ck(int i, int i2) {
        this.cHc = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.cHc;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.iDI = (float) (this.mScreenWidth / 750.0d);
    }

    private void cfr() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.iDF.backgroundInfo != null) {
            this.iDC.setVisibility(0);
            if (!TextUtils.isEmpty(this.iDF.backgroundInfo.img)) {
                c.iv().a(this.iDF.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.ns() != null) {
                                    int height = aVar.ns().getHeight();
                                    int width = aVar.ns().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.iDF.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.iDC.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iDC.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.iDC.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iDC.getLayoutParams().height = FormCardView.this.cHc;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.iDF.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.vS(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.iDC);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.iDC.setImageBitmap(null);
                                FormCardView.this.iDC.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.iDC.setImageBitmap(null);
                                FormCardView.this.iDC.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.iDC.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.iDC.setVisibility(8);
    }

    private void cfs() {
        FormCard.f fVar = this.iDF.resultInfo;
        float dimension = this.mContext.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(R.dimen.fontsize28);
        int color = this.mContext.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.iDD.setText(fVar.title);
            this.iDD.setTextColor(-1);
            this.iDD.setTextSize(0, dimension);
            this.iDE.setText(fVar.desc);
            this.iDE.setTextColor(color);
            this.iDE.setTextSize(0, dimension2);
        }
    }

    private void cft() {
        if (this.iDF.itemList != null && this.iDF.itemList.size() > 0) {
            int size = this.iDF.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.iDF.itemList.get(i);
                if (bVar != null) {
                    switch (bVar.type) {
                        case 1:
                            a(bVar, new TitleView(this.mActivity), i, size);
                            continue;
                        case 2:
                            a(bVar, new CommitView(this.mActivity), i, size);
                            continue;
                        case 3:
                        case 4:
                        case 5:
                            a(bVar, new EditView(this.mActivity), i, size);
                            continue;
                        case 6:
                        case 7:
                        case 8:
                            a(bVar, new PickerView(this.mActivity), i, size);
                            continue;
                    }
                }
            }
        }
    }

    private void cfu() {
        this.iDB.removeAllViews();
        if (this.iDG != null) {
            this.iDG.clear();
        } else {
            this.iDG = new ArrayList();
        }
        this.iDz.setVisibility(0);
        this.iDB.setVisibility(0);
        this.iDA.setVisibility(8);
        this.iDz.setClickable(true);
        this.iDC.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aP(this.iDI);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.iDB.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.cfw());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.iDI);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.cfw()));
        }
    }

    public void a(a aVar) {
        if (this.iDG == null) {
            this.iDG = new ArrayList();
        }
        this.iDG.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject dY;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.cfn()) {
                        View frameView = formView.getFrameView();
                        if (frameView != null) {
                            formView.a(frameView, FormItemBaseView.DrawableType.ERROR_FRAME);
                        }
                        z = false;
                        z2 = z;
                    } else {
                        View frameView2 = formView.getFrameView();
                        if (frameView2 != null) {
                            formView.a(frameView2, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (z2) {
                JSONArray jSONArray = new JSONArray();
                for (a aVar2 : list) {
                    FormItemBaseView formView2 = aVar2.getFormView();
                    if (formView2 != null && (dY = dY(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(dY);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.iDz.setClickable(false);
                return;
            }
            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.iDz.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfv() {
        this.iDz.setVisibility(4);
        this.iDB.setVisibility(4);
        this.iDA.setVisibility(0);
    }

    private JSONObject dY(String str, String str2) {
        if (TextUtils.equals(str2, "NEGLIGIBLE")) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", str);
            jSONObject.put(UBC.CONTENT_KEY_VALUE, str2);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private void e(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.iDz.setClickable(true);
        } else {
            b.ceN().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.iDF.setCommitState(true);
                            FormCardView.this.cfv();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new e().j(hVar.errorString);
                            FormCardView.this.iDF.setCommitState(false);
                        } else {
                            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.iDF.setCommitState(false);
                        }
                    }
                    FormCardView.this.iDz.setClickable(true);
                }
            });
        }
    }
}
