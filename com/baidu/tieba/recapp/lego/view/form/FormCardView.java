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
    private TextView iDA;
    private TextView iDB;
    private FormCard iDC;
    private List<a> iDD;
    private String iDE;
    private float iDF;
    private int iDG;
    private TitleView iDv;
    private CommitView iDw;
    private LinearLayout iDx;
    private LinearLayout iDy;
    private ImageView iDz;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean cfk();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iDE = "";
        this.mScreenWidth = 0;
        this.cHb = 0;
        this.iDF = 1.0f;
        this.iDG = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bHK() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.iDv = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.iDz = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.iDz.setEnabled(false);
        this.iDw = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.iDy = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.iDx = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.iDA = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.iDB = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.iDw != null) {
            this.iDw.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.iDD, FormCardView.this.iDw.getPostUrl(), FormCardView.this.iDE);
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
        if (formCard != null && formCard.mIsLegal && this.iDC != formCard) {
            cfr();
            this.iDC = formCard;
            this.iDE = formCard.getItemId();
            ck(formCard.mWidth, formCard.mHeight);
            this.iDv.aP(this.iDF);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iDv.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iDF);
            }
            this.iDw.aP(this.iDF);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iDw.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iDF);
            }
            this.iDv.a(formCard.titleInfo);
            this.iDw.a(formCard.commitInfo);
            b.ceK().a(new com.baidu.tieba.recapp.a.a(this.iDw.getPostUrl()));
            cfo();
            cfq();
            cfp();
            a(this.iDv);
            a(this.iDw);
            if (formCard.isCommitSuccess()) {
                cfs();
            }
            if (!formCard.mHasShown) {
                r.ceJ().ceF().ck(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void ck(int i, int i2) {
        this.cHb = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.cHb;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.iDF = (float) (this.mScreenWidth / 750.0d);
    }

    private void cfo() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.iDC.backgroundInfo != null) {
            this.iDz.setVisibility(0);
            if (!TextUtils.isEmpty(this.iDC.backgroundInfo.img)) {
                c.iv().a(this.iDC.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.iDC.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.iDz.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iDz.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.iDz.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iDz.getLayoutParams().height = FormCardView.this.cHb;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.iDC.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.vS(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.iDz);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.iDz.setImageBitmap(null);
                                FormCardView.this.iDz.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.iDz.setImageBitmap(null);
                                FormCardView.this.iDz.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.iDz.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.iDz.setVisibility(8);
    }

    private void cfp() {
        FormCard.f fVar = this.iDC.resultInfo;
        float dimension = this.mContext.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(R.dimen.fontsize28);
        int color = this.mContext.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.iDA.setText(fVar.title);
            this.iDA.setTextColor(-1);
            this.iDA.setTextSize(0, dimension);
            this.iDB.setText(fVar.desc);
            this.iDB.setTextColor(color);
            this.iDB.setTextSize(0, dimension2);
        }
    }

    private void cfq() {
        if (this.iDC.itemList != null && this.iDC.itemList.size() > 0) {
            int size = this.iDC.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.iDC.itemList.get(i);
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

    private void cfr() {
        this.iDy.removeAllViews();
        if (this.iDD != null) {
            this.iDD.clear();
        } else {
            this.iDD = new ArrayList();
        }
        this.iDw.setVisibility(0);
        this.iDy.setVisibility(0);
        this.iDx.setVisibility(8);
        this.iDw.setClickable(true);
        this.iDz.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aP(this.iDF);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.iDy.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.cft());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.iDF);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.cft()));
        }
    }

    public void a(a aVar) {
        if (this.iDD == null) {
            this.iDD = new ArrayList();
        }
        this.iDD.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject dY;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.cfk()) {
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
                this.iDw.setClickable(false);
                return;
            }
            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.iDw.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfs() {
        this.iDw.setVisibility(4);
        this.iDy.setVisibility(4);
        this.iDx.setVisibility(0);
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
            this.iDw.setClickable(true);
        } else {
            b.ceK().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.iDC.setCommitState(true);
                            FormCardView.this.cfs();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new e().j(hVar.errorString);
                            FormCardView.this.iDC.setCommitState(false);
                        } else {
                            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.iDC.setCommitState(false);
                        }
                    }
                    FormCardView.this.iDw.setClickable(true);
                }
            });
        }
    }
}
