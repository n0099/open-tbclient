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
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.a.b;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.baidu.tieba.recapp.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String aMj;
    private ImageView kOA;
    private TextView kOB;
    private TextView kOC;
    private FormCard kOD;
    private List<a> kOE;
    private float kOF;
    private int kOG;
    private TitleView kOw;
    private CommitView kOx;
    private LinearLayout kOy;
    private LinearLayout kOz;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes13.dex */
    public interface a {
        boolean cVb();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aMj = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.kOF = 1.0f;
        this.kOG = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ctJ() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.kOw = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.kOA = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.kOA.setEnabled(false);
        this.kOx = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.kOz = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.kOy = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.kOB = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.kOC = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.kOx != null) {
            this.kOx.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.kOE, FormCardView.this.kOx.getPostUrl(), FormCardView.this.aMj);
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
        if (formCard != null && formCard.mIsLegal && this.kOD != formCard) {
            cVi();
            this.kOD = formCard;
            this.aMj = formCard.getItemId();
            cN(formCard.mWidth, formCard.mHeight);
            this.kOw.as(this.kOF);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kOw.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.kOF);
            }
            this.kOx.as(this.kOF);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.kOx.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.kOF);
            }
            this.kOw.a(formCard.titleInfo);
            this.kOx.a(formCard.commitInfo);
            b.cUD().a(new com.baidu.tieba.recapp.a.a(this.kOx.getPostUrl()));
            cVf();
            cVh();
            cVg();
            a(this.kOw);
            a(this.kOx);
            if (formCard.isCommitSuccess()) {
                cVj();
            }
            if (!formCard.mHasShown) {
                q.cUC().cUy().dt(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cN(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.kOF = (float) (this.mScreenWidth / 750.0d);
    }

    private void cVf() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.kOD.backgroundInfo != null) {
            this.kOA.setVisibility(0);
            if (!TextUtils.isEmpty(this.kOD.backgroundInfo.img)) {
                c.kX().a(this.kOD.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.kOD.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.kOA.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.kOA.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.kOA.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.kOA.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int dT = com.baidu.tieba.lego.card.d.a.dT(FormCardView.this.kOD.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.yJ(dT)) {
                                            FormCardView.this.mRootView.setBackgroundColor(dT);
                                        }
                                        aVar.drawImageTo(FormCardView.this.kOA);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.kOA.setImageBitmap(null);
                                FormCardView.this.kOA.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.kOA.setImageBitmap(null);
                                FormCardView.this.kOA.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.kOA.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.kOA.setVisibility(8);
    }

    private void cVg() {
        FormCard.f fVar = this.kOD.resultInfo;
        float dimension = this.dIF.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.dIF.getResources().getDimension(R.dimen.fontsize28);
        int color = this.dIF.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.kOB.setText(fVar.title);
            this.kOB.setTextColor(-1);
            this.kOB.setTextSize(0, dimension);
            this.kOC.setText(fVar.desc);
            this.kOC.setTextColor(color);
            this.kOC.setTextSize(0, dimension2);
        }
    }

    private void cVh() {
        if (this.kOD.itemList != null && this.kOD.itemList.size() > 0) {
            int size = this.kOD.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.kOD.itemList.get(i);
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

    private void cVi() {
        this.kOz.removeAllViews();
        if (this.kOE != null) {
            this.kOE.clear();
        } else {
            this.kOE = new ArrayList();
        }
        this.kOx.setVisibility(0);
        this.kOz.setVisibility(0);
        this.kOy.setVisibility(8);
        this.kOx.setClickable(true);
        this.kOA.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.as(this.kOF);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.kOz.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.cVk());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.kOF);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.cVk()));
        }
    }

    public void a(a aVar) {
        if (this.kOE == null) {
            this.kOE = new ArrayList();
        }
        this.kOE.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject fe;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.cVb()) {
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
                    if (formView2 != null && (fe = fe(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(fe);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.kOx.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.kOx.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVj() {
        this.kOx.setVisibility(4);
        this.kOz.setVisibility(4);
        this.kOy.setVisibility(0);
    }

    private JSONObject fe(String str, String str2) {
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
            this.kOx.setClickable(true);
        } else {
            b.cUD().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.kOD.setCommitState(true);
                            FormCardView.this.cVj();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.kOD.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.kOD.setCommitState(false);
                        }
                    }
                    FormCardView.this.kOx.setClickable(true);
                }
            });
        }
    }
}
