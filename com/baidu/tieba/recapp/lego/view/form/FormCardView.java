package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.a.b;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.baidu.tieba.recapp.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String anT;
    private LinearLayout jKA;
    private LinearLayout jKB;
    private ImageView jKC;
    private TextView jKD;
    private TextView jKE;
    private FormCard jKF;
    private List<a> jKG;
    private float jKH;
    private int jKI;
    private TitleView jKy;
    private CommitView jKz;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes13.dex */
    public interface a {
        boolean cCY();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.anT = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.jKH = 1.0f;
        this.jKI = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccg() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.jKy = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.jKC = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.jKC.setEnabled(false);
        this.jKz = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.jKB = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.jKA = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.jKD = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.jKE = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.jKz != null) {
            this.jKz.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.jKG, FormCardView.this.jKz.getPostUrl(), FormCardView.this.anT);
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
    public void d(FormCard formCard) {
        if (formCard != null && formCard.mIsLegal && this.jKF != formCard) {
            cDf();
            this.jKF = formCard;
            this.anT = formCard.getItemId();
            cB(formCard.mWidth, formCard.mHeight);
            this.jKy.aJ(this.jKH);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jKy.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.jKH);
            }
            this.jKz.aJ(this.jKH);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.jKz.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.jKH);
            }
            this.jKy.a(formCard.titleInfo);
            this.jKz.a(formCard.commitInfo);
            b.cCx().a(new com.baidu.tieba.recapp.a.a(this.jKz.getPostUrl()));
            cDc();
            cDe();
            cDd();
            a(this.jKy);
            a(this.jKz);
            if (formCard.isCommitSuccess()) {
                cDg();
            }
            if (!formCard.mHasShown) {
                r.cCw().cCs().cK(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cB(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.jKH = (float) (this.mScreenWidth / 750.0d);
    }

    private void cDc() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.jKF.backgroundInfo != null) {
            this.jKC.setVisibility(0);
            if (!TextUtils.isEmpty(this.jKF.backgroundInfo.img)) {
                c.gr().a(this.jKF.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.getRawBitmap() != null) {
                                    int height = aVar.getRawBitmap().getHeight();
                                    int width = aVar.getRawBitmap().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.jKF.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.jKC.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.jKC.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.jKC.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.jKC.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int cG = com.baidu.tieba.lego.card.d.a.cG(FormCardView.this.jKF.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.xr(cG)) {
                                            FormCardView.this.mRootView.setBackgroundColor(cG);
                                        }
                                        aVar.drawImageTo(FormCardView.this.jKC);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.jKC.setImageBitmap(null);
                                FormCardView.this.jKC.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.jKC.setImageBitmap(null);
                                FormCardView.this.jKC.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.jKC.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.jKC.setVisibility(8);
    }

    private void cDd() {
        FormCard.f fVar = this.jKF.resultInfo;
        float dimension = this.cVi.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.cVi.getResources().getDimension(R.dimen.fontsize28);
        int color = this.cVi.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.jKD.setText(fVar.title);
            this.jKD.setTextColor(-1);
            this.jKD.setTextSize(0, dimension);
            this.jKE.setText(fVar.desc);
            this.jKE.setTextColor(color);
            this.jKE.setTextSize(0, dimension2);
        }
    }

    private void cDe() {
        if (this.jKF.itemList != null && this.jKF.itemList.size() > 0) {
            int size = this.jKF.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.jKF.itemList.get(i);
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

    private void cDf() {
        this.jKB.removeAllViews();
        if (this.jKG != null) {
            this.jKG.clear();
        } else {
            this.jKG = new ArrayList();
        }
        this.jKz.setVisibility(0);
        this.jKB.setVisibility(0);
        this.jKA.setVisibility(8);
        this.jKz.setClickable(true);
        this.jKC.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aJ(this.jKH);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.jKB.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.cDh());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.jKH);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.cDh()));
        }
    }

    public void a(a aVar) {
        if (this.jKG == null) {
            this.jKG = new ArrayList();
        }
        this.jKG.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject eq;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.cCY()) {
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
                    if (formView2 != null && (eq = eq(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(eq);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.jKz.setClickable(false);
                return;
            }
            new d().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.jKz.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDg() {
        this.jKz.setVisibility(4);
        this.jKB.setVisibility(4);
        this.jKA.setVisibility(0);
    }

    private JSONObject eq(String str, String str2) {
        if (TextUtils.equals(str2, "NEGLIGIBLE")) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", str);
            jSONObject.put("value", str2);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private void e(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.jKz.setClickable(true);
        } else {
            b.cCx().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.jKF.setCommitState(true);
                            FormCardView.this.cDg();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new d().showFailToast(hVar.errorString);
                            FormCardView.this.jKF.setCommitState(false);
                        } else {
                            new d().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.jKF.setCommitState(false);
                        }
                    }
                    FormCardView.this.jKz.setClickable(true);
                }
            });
        }
    }
}
