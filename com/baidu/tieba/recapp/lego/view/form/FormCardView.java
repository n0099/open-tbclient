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
import com.baidu.sapi2.result.AddressManageResult;
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
    private int cJu;
    private float iNA;
    private int iNB;
    private TitleView iNq;
    private CommitView iNr;
    private LinearLayout iNs;
    private LinearLayout iNt;
    private ImageView iNu;
    private TextView iNv;
    private TextView iNw;
    private FormCard iNx;
    private List<a> iNy;
    private String iNz;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean cjk();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iNz = "";
        this.mScreenWidth = 0;
        this.cJu = 0;
        this.iNA = 1.0f;
        this.iNB = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bLw() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.iNq = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.iNu = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.iNu.setEnabled(false);
        this.iNr = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.iNt = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.iNs = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.iNv = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.iNw = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.iNr != null) {
            this.iNr.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.iNy, FormCardView.this.iNr.getPostUrl(), FormCardView.this.iNz);
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
        if (formCard != null && formCard.mIsLegal && this.iNx != formCard) {
            cjr();
            this.iNx = formCard;
            this.iNz = formCard.getItemId();
            cq(formCard.mWidth, formCard.mHeight);
            this.iNq.aR(this.iNA);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iNq.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iNA);
            }
            this.iNr.aR(this.iNA);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iNr.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iNA);
            }
            this.iNq.a(formCard.titleInfo);
            this.iNr.a(formCard.commitInfo);
            b.ciK().a(new com.baidu.tieba.recapp.a.a(this.iNr.getPostUrl()));
            cjo();
            cjq();
            cjp();
            a(this.iNq);
            a(this.iNr);
            if (formCard.isCommitSuccess()) {
                cjs();
            }
            if (!formCard.mHasShown) {
                r.ciJ().ciF().cl(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cq(int i, int i2) {
        this.cJu = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.cJu;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.iNA = (float) (this.mScreenWidth / 750.0d);
    }

    private void cjo() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.iNx.backgroundInfo != null) {
            this.iNu.setVisibility(0);
            if (!TextUtils.isEmpty(this.iNx.backgroundInfo.img)) {
                c.iE().a(this.iNx.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.iNx.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.iNu.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iNu.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.iNu.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iNu.getLayoutParams().height = FormCardView.this.cJu;
                                                break;
                                        }
                                        int cE = com.baidu.tieba.lego.card.d.a.cE(FormCardView.this.iNx.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.wz(cE)) {
                                            FormCardView.this.mRootView.setBackgroundColor(cE);
                                        }
                                        aVar.a(FormCardView.this.iNu);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.iNu.setImageBitmap(null);
                                FormCardView.this.iNu.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.iNu.setImageBitmap(null);
                                FormCardView.this.iNu.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.iNu.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.iNu.setVisibility(8);
    }

    private void cjp() {
        FormCard.f fVar = this.iNx.resultInfo;
        float dimension = this.mContext.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(R.dimen.fontsize28);
        int color = this.mContext.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.iNv.setText(fVar.title);
            this.iNv.setTextColor(-1);
            this.iNv.setTextSize(0, dimension);
            this.iNw.setText(fVar.desc);
            this.iNw.setTextColor(color);
            this.iNw.setTextSize(0, dimension2);
        }
    }

    private void cjq() {
        if (this.iNx.itemList != null && this.iNx.itemList.size() > 0) {
            int size = this.iNx.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.iNx.itemList.get(i);
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

    private void cjr() {
        this.iNt.removeAllViews();
        if (this.iNy != null) {
            this.iNy.clear();
        } else {
            this.iNy = new ArrayList();
        }
        this.iNr.setVisibility(0);
        this.iNt.setVisibility(0);
        this.iNs.setVisibility(8);
        this.iNr.setClickable(true);
        this.iNu.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aR(this.iNA);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.iNt.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.cjt());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.iNA);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.cjt()));
        }
    }

    public void a(a aVar) {
        if (this.iNy == null) {
            this.iNy = new ArrayList();
        }
        this.iNy.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject ea;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.cjk()) {
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
                    if (formView2 != null && (ea = ea(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(ea);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.iNr.setClickable(false);
                return;
            }
            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.iNr.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjs() {
        this.iNr.setVisibility(4);
        this.iNt.setVisibility(4);
        this.iNs.setVisibility(0);
    }

    private JSONObject ea(String str, String str2) {
        if (TextUtils.equals(str2, "NEGLIGIBLE")) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AddressManageResult.KEY_TAG, str);
            jSONObject.put(UBC.CONTENT_KEY_VALUE, str2);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private void e(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.iNr.setClickable(true);
        } else {
            b.ciK().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.iNx.setCommitState(true);
                            FormCardView.this.cjs();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new e().j(hVar.errorString);
                            FormCardView.this.iNx.setCommitState(false);
                        } else {
                            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.iNx.setCommitState(false);
                        }
                    }
                    FormCardView.this.iNr.setClickable(true);
                }
            });
        }
    }
}
