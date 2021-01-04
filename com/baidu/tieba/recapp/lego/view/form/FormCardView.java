package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
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
import com.baidu.tieba.recapp.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String aZz;
    private Activity mActivity;
    private TitleView mQK;
    private CommitView mQL;
    private LinearLayout mQM;
    private LinearLayout mQN;
    private ImageView mQO;
    private TextView mQP;
    private TextView mQQ;
    private FormCard mQR;
    private List<a> mQS;
    private float mQT;
    private int mQU;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes8.dex */
    public interface a {
        boolean dFs();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aZz = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.mQT = 1.0f;
        this.mQU = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddH() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.mQK = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.mQO = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.mQO.setEnabled(false);
        this.mQL = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.mQN = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.mQM = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.mQP = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.mQQ = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.mQL != null) {
            this.mQL.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.mQS, FormCardView.this.mQL.getPostUrl(), FormCardView.this.aZz);
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
        if (formCard != null && formCard.mIsLegal && this.mQR != formCard) {
            dFz();
            this.mQR = formCard;
            this.aZz = formCard.getItemId();
            dl(formCard.mWidth, formCard.mHeight);
            this.mQK.aW(this.mQT);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mQK.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mQT);
            }
            this.mQL.aW(this.mQT);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mQL.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mQT);
            }
            this.mQK.a(formCard.titleInfo);
            this.mQL.a(formCard.commitInfo);
            b.dEW().a(new com.baidu.tieba.recapp.a.a(this.mQL.getPostUrl()));
            dFw();
            dFy();
            dFx();
            a(this.mQK);
            a(this.mQL);
            if (formCard.isCommitSuccess()) {
                dFA();
            }
            if (!formCard.mHasShown) {
                r.dEV().dER().ek(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void dl(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.mQT = (float) (this.mScreenWidth / 750.0d);
    }

    private void dFw() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.mQR.backgroundInfo != null) {
            this.mQO.setVisibility(0);
            if (!TextUtils.isEmpty(this.mQR.backgroundInfo.img)) {
                d.mx().a(this.mQR.backgroundInfo.img, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.c
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.getRawBitmap() != null) {
                                    int height = aVar.getRawBitmap().getHeight();
                                    int width = aVar.getRawBitmap().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.mQR.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.mQO.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mQO.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.mQO.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mQO.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int sF = com.baidu.tieba.lego.card.c.b.sF(FormCardView.this.mQR.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.c.b.Fh(sF)) {
                                            FormCardView.this.mRootView.setBackgroundColor(sF);
                                        }
                                        aVar.drawImageTo(FormCardView.this.mQO);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.mQO.setImageBitmap(null);
                                FormCardView.this.mQO.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.mQO.setImageBitmap(null);
                                FormCardView.this.mQO.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.mQO.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.mQO.setVisibility(8);
    }

    private void dFx() {
        FormCard.f fVar = this.mQR.resultInfo;
        float dimension = this.eXu.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.eXu.getResources().getDimension(R.dimen.fontsize28);
        int color = this.eXu.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.mQP.setText(fVar.title);
            this.mQP.setTextColor(-1);
            this.mQP.setTextSize(0, dimension);
            this.mQQ.setText(fVar.desc);
            this.mQQ.setTextColor(color);
            this.mQQ.setTextSize(0, dimension2);
        }
    }

    private void dFy() {
        if (this.mQR.itemList != null && this.mQR.itemList.size() > 0) {
            int size = this.mQR.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.mQR.itemList.get(i);
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

    private void dFz() {
        this.mQN.removeAllViews();
        if (this.mQS != null) {
            com.baidu.tieba.lego.card.c.a.clear(this.mQS);
        } else {
            this.mQS = new ArrayList();
        }
        this.mQL.setVisibility(0);
        this.mQN.setVisibility(0);
        this.mQM.setVisibility(8);
        this.mQL.setClickable(true);
        this.mQO.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aW(this.mQT);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.mQN.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.dFB());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.mQT);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.dFB()));
        }
    }

    public void a(a aVar) {
        if (this.mQS == null) {
            this.mQS = new ArrayList();
        }
        com.baidu.tieba.lego.card.c.a.a(this.mQS, aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject gf;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.dFs()) {
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
                    if (formView2 != null && (gf = gf(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(gf);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.mQL.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.mQL.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFA() {
        this.mQL.setVisibility(4);
        this.mQN.setVisibility(4);
        this.mQM.setVisibility(0);
    }

    private JSONObject gf(String str, String str2) {
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
            this.mQL.setClickable(true);
        } else {
            b.dEW().a(null, str, hashMap, new e() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.mQR.setCommitState(true);
                            FormCardView.this.dFA();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.mQR.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.mQR.setCommitState(false);
                        }
                    }
                    FormCardView.this.mQL.setClickable(true);
                }
            });
        }
    }
}
