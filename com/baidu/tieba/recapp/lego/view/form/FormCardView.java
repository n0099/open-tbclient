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
    private int cIw;
    private TitleView iJQ;
    private CommitView iJR;
    private LinearLayout iJS;
    private LinearLayout iJT;
    private ImageView iJU;
    private TextView iJV;
    private TextView iJW;
    private FormCard iJX;
    private List<a> iJY;
    private String iJZ;
    private float iKa;
    private int iKb;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean cie();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iJZ = "";
        this.mScreenWidth = 0;
        this.cIw = 0;
        this.iKa = 1.0f;
        this.iKb = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bKv() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.iJQ = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.iJU = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.iJU.setEnabled(false);
        this.iJR = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.iJT = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.iJS = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.iJV = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.iJW = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.iJR != null) {
            this.iJR.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.iJY, FormCardView.this.iJR.getPostUrl(), FormCardView.this.iJZ);
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
        if (formCard != null && formCard.mIsLegal && this.iJX != formCard) {
            cil();
            this.iJX = formCard;
            this.iJZ = formCard.getItemId();
            cq(formCard.mWidth, formCard.mHeight);
            this.iJQ.aQ(this.iKa);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iJQ.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iKa);
            }
            this.iJR.aQ(this.iKa);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iJR.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iKa);
            }
            this.iJQ.a(formCard.titleInfo);
            this.iJR.a(formCard.commitInfo);
            b.chE().a(new com.baidu.tieba.recapp.a.a(this.iJR.getPostUrl()));
            cii();
            cik();
            cij();
            a(this.iJQ);
            a(this.iJR);
            if (formCard.isCommitSuccess()) {
                cim();
            }
            if (!formCard.mHasShown) {
                r.chD().chz().cl(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cq(int i, int i2) {
        this.cIw = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.cIw;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.iKa = (float) (this.mScreenWidth / 750.0d);
    }

    private void cii() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.iJX.backgroundInfo != null) {
            this.iJU.setVisibility(0);
            if (!TextUtils.isEmpty(this.iJX.backgroundInfo.img)) {
                c.iE().a(this.iJX.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.iJX.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.iJU.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iJU.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.iJU.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iJU.getLayoutParams().height = FormCardView.this.cIw;
                                                break;
                                        }
                                        int cE = com.baidu.tieba.lego.card.d.a.cE(FormCardView.this.iJX.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.wu(cE)) {
                                            FormCardView.this.mRootView.setBackgroundColor(cE);
                                        }
                                        aVar.a(FormCardView.this.iJU);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.iJU.setImageBitmap(null);
                                FormCardView.this.iJU.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.iJU.setImageBitmap(null);
                                FormCardView.this.iJU.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.iJU.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.iJU.setVisibility(8);
    }

    private void cij() {
        FormCard.f fVar = this.iJX.resultInfo;
        float dimension = this.mContext.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(R.dimen.fontsize28);
        int color = this.mContext.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.iJV.setText(fVar.title);
            this.iJV.setTextColor(-1);
            this.iJV.setTextSize(0, dimension);
            this.iJW.setText(fVar.desc);
            this.iJW.setTextColor(color);
            this.iJW.setTextSize(0, dimension2);
        }
    }

    private void cik() {
        if (this.iJX.itemList != null && this.iJX.itemList.size() > 0) {
            int size = this.iJX.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.iJX.itemList.get(i);
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

    private void cil() {
        this.iJT.removeAllViews();
        if (this.iJY != null) {
            this.iJY.clear();
        } else {
            this.iJY = new ArrayList();
        }
        this.iJR.setVisibility(0);
        this.iJT.setVisibility(0);
        this.iJS.setVisibility(8);
        this.iJR.setClickable(true);
        this.iJU.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aQ(this.iKa);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.iJT.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.cin());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.iKa);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.cin()));
        }
    }

    public void a(a aVar) {
        if (this.iJY == null) {
            this.iJY = new ArrayList();
        }
        this.iJY.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject dZ;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.cie()) {
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
                this.iJR.setClickable(false);
                return;
            }
            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.iJR.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cim() {
        this.iJR.setVisibility(4);
        this.iJT.setVisibility(4);
        this.iJS.setVisibility(0);
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
            this.iJR.setClickable(true);
        } else {
            b.chE().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.iJX.setCommitState(true);
                            FormCardView.this.cim();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new e().j(hVar.errorString);
                            FormCardView.this.iJX.setCommitState(false);
                        } else {
                            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.iJX.setCommitState(false);
                        }
                    }
                    FormCardView.this.iJR.setClickable(true);
                }
            });
        }
    }
}
