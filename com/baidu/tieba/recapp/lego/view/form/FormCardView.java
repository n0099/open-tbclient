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
    private int cHb;
    private LinearLayout iDA;
    private ImageView iDB;
    private TextView iDC;
    private TextView iDD;
    private FormCard iDE;
    private List<a> iDF;
    private String iDG;
    private float iDH;
    private int iDI;
    private TitleView iDx;
    private CommitView iDy;
    private LinearLayout iDz;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean cfm();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iDG = "";
        this.mScreenWidth = 0;
        this.cHb = 0;
        this.iDH = 1.0f;
        this.iDI = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bHN() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.iDx = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.iDB = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.iDB.setEnabled(false);
        this.iDy = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.iDA = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.iDz = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.iDC = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.iDD = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.iDy != null) {
            this.iDy.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.iDF, FormCardView.this.iDy.getPostUrl(), FormCardView.this.iDG);
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
        if (formCard != null && formCard.mIsLegal && this.iDE != formCard) {
            cft();
            this.iDE = formCard;
            this.iDG = formCard.getItemId();
            ck(formCard.mWidth, formCard.mHeight);
            this.iDx.aP(this.iDH);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iDx.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iDH);
            }
            this.iDy.aP(this.iDH);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iDy.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iDH);
            }
            this.iDx.a(formCard.titleInfo);
            this.iDy.a(formCard.commitInfo);
            b.ceM().a(new com.baidu.tieba.recapp.a.a(this.iDy.getPostUrl()));
            cfq();
            cfs();
            cfr();
            a(this.iDx);
            a(this.iDy);
            if (formCard.isCommitSuccess()) {
                cfu();
            }
            if (!formCard.mHasShown) {
                r.ceL().ceH().ck(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void ck(int i, int i2) {
        this.cHb = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.cHb;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.iDH = (float) (this.mScreenWidth / 750.0d);
    }

    private void cfq() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.iDE.backgroundInfo != null) {
            this.iDB.setVisibility(0);
            if (!TextUtils.isEmpty(this.iDE.backgroundInfo.img)) {
                c.iv().a(this.iDE.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.iDE.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.iDB.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iDB.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.iDB.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iDB.getLayoutParams().height = FormCardView.this.cHb;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.iDE.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.vS(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.iDB);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.iDB.setImageBitmap(null);
                                FormCardView.this.iDB.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.iDB.setImageBitmap(null);
                                FormCardView.this.iDB.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.iDB.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.iDB.setVisibility(8);
    }

    private void cfr() {
        FormCard.f fVar = this.iDE.resultInfo;
        float dimension = this.mContext.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(R.dimen.fontsize28);
        int color = this.mContext.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.iDC.setText(fVar.title);
            this.iDC.setTextColor(-1);
            this.iDC.setTextSize(0, dimension);
            this.iDD.setText(fVar.desc);
            this.iDD.setTextColor(color);
            this.iDD.setTextSize(0, dimension2);
        }
    }

    private void cfs() {
        if (this.iDE.itemList != null && this.iDE.itemList.size() > 0) {
            int size = this.iDE.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.iDE.itemList.get(i);
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

    private void cft() {
        this.iDA.removeAllViews();
        if (this.iDF != null) {
            this.iDF.clear();
        } else {
            this.iDF = new ArrayList();
        }
        this.iDy.setVisibility(0);
        this.iDA.setVisibility(0);
        this.iDz.setVisibility(8);
        this.iDy.setClickable(true);
        this.iDB.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aP(this.iDH);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.iDA.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.cfv());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.iDH);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.cfv()));
        }
    }

    public void a(a aVar) {
        if (this.iDF == null) {
            this.iDF = new ArrayList();
        }
        this.iDF.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject dY;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.cfm()) {
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
                this.iDy.setClickable(false);
                return;
            }
            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.iDy.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfu() {
        this.iDy.setVisibility(4);
        this.iDA.setVisibility(4);
        this.iDz.setVisibility(0);
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
            this.iDy.setClickable(true);
        } else {
            b.ceM().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.iDE.setCommitState(true);
                            FormCardView.this.cfu();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new e().j(hVar.errorString);
                            FormCardView.this.iDE.setCommitState(false);
                        } else {
                            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.iDE.setCommitState(false);
                        }
                    }
                    FormCardView.this.iDy.setClickable(true);
                }
            });
        }
    }
}
