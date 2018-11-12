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
import com.baidu.tbadk.a.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.e;
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
/* loaded from: classes3.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private int bkb;
    private TitleView gIM;
    private CommitView gIN;
    private LinearLayout gIO;
    private LinearLayout gIP;
    private ImageView gIQ;
    private TextView gIR;
    private TextView gIS;
    private FormCard gIT;
    private List<a> gIU;
    private String gIV;
    private float gIW;
    private int gIX;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean bth();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gIV = "";
        this.mScreenWidth = 0;
        this.bkb = 0;
        this.gIW = 1.0f;
        this.gIX = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aWt() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(e.h.card_form, (ViewGroup) null);
        this.gIM = (TitleView) this.mRootView.findViewById(e.g.form_title_view);
        this.gIQ = (ImageView) this.mRootView.findViewById(e.g.tb_img_background);
        this.gIQ.setEnabled(false);
        this.gIN = (CommitView) this.mRootView.findViewById(e.g.form_commit_view);
        this.gIP = (LinearLayout) this.mRootView.findViewById(e.g.item_content_view);
        this.gIO = (LinearLayout) this.mRootView.findViewById(e.g.form_commit_success_view);
        this.gIR = (TextView) this.mRootView.findViewById(e.g.form_success_title);
        this.gIS = (TextView) this.mRootView.findViewById(e.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gIN != null) {
            this.gIN.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.gIU, FormCardView.this.gIN.getPostUrl(), FormCardView.this.gIV);
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
        if (formCard != null && formCard.mIsLegal && this.gIT != formCard) {
            bto();
            this.gIT = formCard;
            this.gIV = formCard.getItemId();
            bI(formCard.mWidth, formCard.mHeight);
            this.gIM.ay(this.gIW);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gIM.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0200e.form_size90)) * this.gIW);
            }
            this.gIN.ay(this.gIW);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gIN.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0200e.form_size90)) * this.gIW);
            }
            this.gIM.a(formCard.titleInfo);
            this.gIN.a(formCard.commitInfo);
            b.bsH().a(new com.baidu.tieba.recapp.a.a(this.gIN.getPostUrl()));
            btl();
            btn();
            btm();
            a(this.gIM);
            a(this.gIN);
            if (formCard.isCommitSuccess()) {
                btp();
            }
            if (!formCard.mHasShown) {
                r.bsG().bsC().aR(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void bI(int i, int i2) {
        this.bkb = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.bkb;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gIW = (float) (this.mScreenWidth / 750.0d);
    }

    private void btl() {
        this.mRootView.setBackgroundResource(e.f.form_defalut_bg_image);
        if (this.gIT.backgroundInfo != null) {
            this.gIQ.setVisibility(0);
            if (!TextUtils.isEmpty(this.gIT.backgroundInfo.img)) {
                c.jA().a(this.gIT.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.oq() != null) {
                                    int height = aVar.oq().getHeight();
                                    int width = aVar.oq().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.gIT.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.gIQ.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gIQ.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.gIQ.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gIQ.getLayoutParams().height = FormCardView.this.bkb;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.gIT.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.qx(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.gIQ);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.gIQ.setImageBitmap(null);
                                FormCardView.this.gIQ.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.gIQ.setImageBitmap(null);
                                FormCardView.this.gIQ.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.gIQ.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gIQ.setVisibility(8);
    }

    private void btm() {
        FormCard.f fVar = this.gIT.resultInfo;
        float dimension = this.mContext.getResources().getDimension(e.C0200e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(e.C0200e.fontsize28);
        int color = this.mContext.getResources().getColor(e.d.form_font_color);
        if (fVar != null) {
            this.gIR.setText(fVar.title);
            this.gIR.setTextColor(-1);
            this.gIR.setTextSize(0, dimension);
            this.gIS.setText(fVar.desc);
            this.gIS.setTextColor(color);
            this.gIS.setTextSize(0, dimension2);
        }
    }

    private void btn() {
        if (this.gIT.itemList != null && this.gIT.itemList.size() > 0) {
            int size = this.gIT.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gIT.itemList.get(i);
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

    private void bto() {
        this.gIP.removeAllViews();
        if (this.gIU != null) {
            this.gIU.clear();
        } else {
            this.gIU = new ArrayList();
        }
        this.gIN.setVisibility(0);
        this.gIP.setVisibility(0);
        this.gIO.setVisibility(8);
        this.gIN.setClickable(true);
        this.gIQ.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.ay(this.gIW);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gIP.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.btq());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0200e.form_size40)) * this.gIW);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.btq()));
        }
    }

    public void a(a aVar) {
        if (this.gIU == null) {
            this.gIU = new ArrayList();
        }
        this.gIU.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject cu;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.bth()) {
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
                    if (formView2 != null && (cu = cu(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(cu);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                c(str, hashMap);
                this.gIN.setClickable(false);
                return;
            }
            new g().showToast(e.f.icon_toast_game_error, e.j.form_commit_error_string);
            this.gIN.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btp() {
        this.gIN.setVisibility(4);
        this.gIP.setVisibility(4);
        this.gIO.setVisibility(0);
    }

    private JSONObject cu(String str, String str2) {
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

    private void c(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.gIN.setClickable(true);
        } else {
            b.bsH().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.aif) {
                            FormCardView.this.gIT.setCommitState(true);
                            FormCardView.this.btp();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new g().f(hVar.errorString);
                            FormCardView.this.gIT.setCommitState(false);
                        } else {
                            new g().showToast(e.f.icon_toast_game_error, e.j.form_commit_fail_string);
                            FormCardView.this.gIT.setCommitState(false);
                        }
                    }
                    FormCardView.this.gIN.setClickable(true);
                }
            });
        }
    }
}
