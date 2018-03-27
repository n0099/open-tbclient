package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.a.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.d;
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
public class c extends com.baidu.tieba.lego.card.e.b<FormCard> {
    private int bHP;
    private e gFQ;
    private com.baidu.tieba.recapp.lego.view.form.a gFR;
    private LinearLayout gFS;
    private LinearLayout gFT;
    private ImageView gFU;
    private TextView gFV;
    private TextView gFW;
    private FormCard gFX;
    private List<a> gFY;
    private String gFZ;
    private float gGa;
    private int gGb;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean boF();

        FormItemBaseView getFormView();

        String getResult();
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gFZ = "";
        this.mScreenWidth = 0;
        this.bHP = 0;
        this.gGa = 1.0f;
        this.gGb = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.ao(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.e.b
    protected View aPT() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.h.card_form, (ViewGroup) null);
        this.gFQ = (e) this.mRootView.findViewById(d.g.form_title_view);
        this.gFU = (ImageView) this.mRootView.findViewById(d.g.tb_img_background);
        this.gFU.setEnabled(false);
        this.gFR = (com.baidu.tieba.recapp.lego.view.form.a) this.mRootView.findViewById(d.g.form_commit_view);
        this.gFT = (LinearLayout) this.mRootView.findViewById(d.g.item_content_view);
        this.gFS = (LinearLayout) this.mRootView.findViewById(d.g.form_commit_success_view);
        this.gFV = (TextView) this.mRootView.findViewById(d.g.form_success_title);
        this.gFW = (TextView) this.mRootView.findViewById(d.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gFR != null) {
            this.gFR.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.b(c.this.gFY, c.this.gFR.getPostUrl(), c.this.gFZ);
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.e.b
    public void a(FormCard formCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.e.b
    /* renamed from: a */
    public void e(FormCard formCard) {
        if (formCard != null && formCard.mIsLegal && this.gFX != formCard) {
            boM();
            this.gFX = formCard;
            this.gFZ = formCard.getItemId();
            cy(formCard.mWidth, formCard.mHeight);
            this.gFQ.aD(this.gGa);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gFQ.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.gGa);
            }
            this.gFR.aD(this.gGa);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gFR.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.gGa);
            }
            this.gFQ.a(formCard.titleInfo);
            this.gFR.a(formCard.commitInfo);
            com.baidu.tieba.recapp.a.b.bog().a(new com.baidu.tieba.recapp.a.a(this.gFR.getPostUrl()));
            boJ();
            boL();
            boK();
            a(this.gFQ);
            a(this.gFR);
            if (formCard.isCommitSuccess()) {
                boN();
            }
            if (!formCard.mHasShown) {
                r.bof().bob().aw(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cy(int i, int i2) {
        this.bHP = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.bHP;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gGa = (float) (this.mScreenWidth / 750.0d);
    }

    private void boJ() {
        this.mRootView.setBackgroundResource(d.f.form_defalut_bg_image);
        if (this.gFX.backgroundInfo != null) {
            this.gFU.setVisibility(0);
            if (!TextUtils.isEmpty(this.gFX.backgroundInfo.img)) {
                com.baidu.adp.lib.f.c.nm().a(this.gFX.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.sh() != null) {
                                    int height = aVar.sh().getHeight();
                                    int width = aVar.sh().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * c.this.mScreenWidth) / width;
                                        switch (c.this.gFX.backgroundInfo.mode) {
                                            case 1:
                                                c.this.gFU.getLayoutParams().width = c.this.mScreenWidth;
                                                c.this.gFU.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                c.this.gFU.getLayoutParams().width = c.this.mScreenWidth;
                                                c.this.gFU.getLayoutParams().height = c.this.bHP;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(c.this.gFX.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.ra(parseColor)) {
                                            c.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(c.this.gFU);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                c.this.gFU.setImageBitmap(null);
                                c.this.gFU.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                c.this.gFU.setImageBitmap(null);
                                c.this.gFU.setVisibility(8);
                                return;
                            }
                        }
                        c.this.gFU.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gFU.setVisibility(8);
    }

    private void boK() {
        FormCard.f fVar = this.gFX.resultInfo;
        float dimension = this.aRI.getResources().getDimension(d.e.fontsize48);
        float dimension2 = this.aRI.getResources().getDimension(d.e.fontsize28);
        int color = this.aRI.getResources().getColor(d.C0141d.form_font_color);
        if (fVar != null) {
            this.gFV.setText(fVar.title);
            this.gFV.setTextColor(-1);
            this.gFV.setTextSize(0, dimension);
            this.gFW.setText(fVar.desc);
            this.gFW.setTextColor(color);
            this.gFW.setTextSize(0, dimension2);
        }
    }

    private void boL() {
        if (this.gFX.itemList != null && this.gFX.itemList.size() > 0) {
            int size = this.gFX.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gFX.itemList.get(i);
                if (bVar != null) {
                    switch (bVar.type) {
                        case 1:
                            a(bVar, new e(this.mActivity), i, size);
                            continue;
                        case 2:
                            a(bVar, new com.baidu.tieba.recapp.lego.view.form.a(this.mActivity), i, size);
                            continue;
                        case 3:
                        case 4:
                        case 5:
                            a(bVar, new b(this.mActivity), i, size);
                            continue;
                        case 6:
                        case 7:
                        case 8:
                            a(bVar, new d(this.mActivity), i, size);
                            continue;
                    }
                }
            }
        }
    }

    private void boM() {
        this.gFT.removeAllViews();
        if (this.gFY != null) {
            this.gFY.clear();
        } else {
            this.gFY = new ArrayList();
        }
        this.gFR.setVisibility(0);
        this.gFT.setVisibility(0);
        this.gFS.setVisibility(8);
        this.gFR.setClickable(true);
        this.gFU.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aD(this.gGa);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gFT.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.boO());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size40)) * this.gGa);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.boO()));
        }
    }

    public void a(a aVar) {
        if (this.gFY == null) {
            this.gFY = new ArrayList();
        }
        this.gFY.add(aVar);
    }

    public void b(List<a> list, String str, String str2) {
        JSONObject bR;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.boF()) {
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
                    if (formView2 != null && (bR = bR(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(bR);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                b(str, hashMap);
                this.gFR.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.e().showToast(d.f.icon_toast_game_error, d.j.form_commit_error_string);
            this.gFR.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boN() {
        this.gFR.setVisibility(4);
        this.gFT.setVisibility(4);
        this.gFS.setVisibility(0);
    }

    private JSONObject bR(String str, String str2) {
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

    private void b(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.gFR.setClickable(true);
        } else {
            com.baidu.tieba.recapp.a.b.bog().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.c.3
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.aGT) {
                            c.this.gFX.setCommitState(true);
                            c.this.boN();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.e().r(hVar.errorString);
                            c.this.gFX.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.e().showToast(d.f.icon_toast_game_error, d.j.form_commit_fail_string);
                            c.this.gFX.setCommitState(false);
                        }
                    }
                    c.this.gFR.setClickable(true);
                }
            });
        }
    }
}
