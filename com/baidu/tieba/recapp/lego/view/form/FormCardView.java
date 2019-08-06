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
    private int cID;
    private TitleView iKU;
    private CommitView iKV;
    private LinearLayout iKW;
    private LinearLayout iKX;
    private ImageView iKY;
    private TextView iKZ;
    private TextView iLa;
    private FormCard iLb;
    private List<a> iLc;
    private String iLd;
    private float iLe;
    private int iLf;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean ciw();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iLd = "";
        this.mScreenWidth = 0;
        this.cID = 0;
        this.iLe = 1.0f;
        this.iLf = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bKJ() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.iKU = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.iKY = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.iKY.setEnabled(false);
        this.iKV = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.iKX = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.iKW = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.iKZ = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.iLa = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.iKV != null) {
            this.iKV.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.iLc, FormCardView.this.iKV.getPostUrl(), FormCardView.this.iLd);
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
        if (formCard != null && formCard.mIsLegal && this.iLb != formCard) {
            ciD();
            this.iLb = formCard;
            this.iLd = formCard.getItemId();
            cq(formCard.mWidth, formCard.mHeight);
            this.iKU.aQ(this.iLe);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iKU.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iLe);
            }
            this.iKV.aQ(this.iLe);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iKV.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iLe);
            }
            this.iKU.a(formCard.titleInfo);
            this.iKV.a(formCard.commitInfo);
            b.chW().a(new com.baidu.tieba.recapp.a.a(this.iKV.getPostUrl()));
            ciA();
            ciC();
            ciB();
            a(this.iKU);
            a(this.iKV);
            if (formCard.isCommitSuccess()) {
                ciE();
            }
            if (!formCard.mHasShown) {
                r.chV().chR().cl(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cq(int i, int i2) {
        this.cID = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.cID;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.iLe = (float) (this.mScreenWidth / 750.0d);
    }

    private void ciA() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.iLb.backgroundInfo != null) {
            this.iKY.setVisibility(0);
            if (!TextUtils.isEmpty(this.iLb.backgroundInfo.img)) {
                c.iE().a(this.iLb.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.nK() != null) {
                                    int height = aVar.nK().getHeight();
                                    int width = aVar.nK().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.iLb.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.iKY.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iKY.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.iKY.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iKY.getLayoutParams().height = FormCardView.this.cID;
                                                break;
                                        }
                                        int cE = com.baidu.tieba.lego.card.d.a.cE(FormCardView.this.iLb.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.ww(cE)) {
                                            FormCardView.this.mRootView.setBackgroundColor(cE);
                                        }
                                        aVar.a(FormCardView.this.iKY);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.iKY.setImageBitmap(null);
                                FormCardView.this.iKY.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.iKY.setImageBitmap(null);
                                FormCardView.this.iKY.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.iKY.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.iKY.setVisibility(8);
    }

    private void ciB() {
        FormCard.f fVar = this.iLb.resultInfo;
        float dimension = this.mContext.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(R.dimen.fontsize28);
        int color = this.mContext.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.iKZ.setText(fVar.title);
            this.iKZ.setTextColor(-1);
            this.iKZ.setTextSize(0, dimension);
            this.iLa.setText(fVar.desc);
            this.iLa.setTextColor(color);
            this.iLa.setTextSize(0, dimension2);
        }
    }

    private void ciC() {
        if (this.iLb.itemList != null && this.iLb.itemList.size() > 0) {
            int size = this.iLb.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.iLb.itemList.get(i);
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

    private void ciD() {
        this.iKX.removeAllViews();
        if (this.iLc != null) {
            this.iLc.clear();
        } else {
            this.iLc = new ArrayList();
        }
        this.iKV.setVisibility(0);
        this.iKX.setVisibility(0);
        this.iKW.setVisibility(8);
        this.iKV.setClickable(true);
        this.iKY.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aQ(this.iLe);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.iKX.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.ciF());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.iLe);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.ciF()));
        }
    }

    public void a(a aVar) {
        if (this.iLc == null) {
            this.iLc = new ArrayList();
        }
        this.iLc.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject dZ;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.ciw()) {
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
                    if (formView2 != null && (dZ = dZ(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(dZ);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.iKV.setClickable(false);
                return;
            }
            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.iKV.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciE() {
        this.iKV.setVisibility(4);
        this.iKX.setVisibility(4);
        this.iKW.setVisibility(0);
    }

    private JSONObject dZ(String str, String str2) {
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
            this.iKV.setClickable(true);
        } else {
            b.chW().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.iLb.setCommitState(true);
                            FormCardView.this.ciE();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new e().j(hVar.errorString);
                            FormCardView.this.iLb.setCommitState(false);
                        } else {
                            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.iLb.setCommitState(false);
                        }
                    }
                    FormCardView.this.iKV.setClickable(true);
                }
            });
        }
    }
}
