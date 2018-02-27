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
    private int bHM;
    private e gFA;
    private com.baidu.tieba.recapp.lego.view.form.a gFB;
    private LinearLayout gFC;
    private LinearLayout gFD;
    private ImageView gFE;
    private TextView gFF;
    private TextView gFG;
    private FormCard gFH;
    private List<a> gFI;
    private String gFJ;
    private float gFK;
    private int gFL;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean boE();

        FormItemBaseView getFormView();

        String getResult();
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gFJ = "";
        this.mScreenWidth = 0;
        this.bHM = 0;
        this.gFK = 1.0f;
        this.gFL = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.ao(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.e.b
    protected View aPS() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.h.card_form, (ViewGroup) null);
        this.gFA = (e) this.mRootView.findViewById(d.g.form_title_view);
        this.gFE = (ImageView) this.mRootView.findViewById(d.g.tb_img_background);
        this.gFE.setEnabled(false);
        this.gFB = (com.baidu.tieba.recapp.lego.view.form.a) this.mRootView.findViewById(d.g.form_commit_view);
        this.gFD = (LinearLayout) this.mRootView.findViewById(d.g.item_content_view);
        this.gFC = (LinearLayout) this.mRootView.findViewById(d.g.form_commit_success_view);
        this.gFF = (TextView) this.mRootView.findViewById(d.g.form_success_title);
        this.gFG = (TextView) this.mRootView.findViewById(d.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gFB != null) {
            this.gFB.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.b(c.this.gFI, c.this.gFB.getPostUrl(), c.this.gFJ);
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
        if (formCard != null && formCard.mIsLegal && this.gFH != formCard) {
            boL();
            this.gFH = formCard;
            this.gFJ = formCard.getItemId();
            cy(formCard.mWidth, formCard.mHeight);
            this.gFA.aD(this.gFK);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gFA.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.gFK);
            }
            this.gFB.aD(this.gFK);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gFB.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.gFK);
            }
            this.gFA.a(formCard.titleInfo);
            this.gFB.a(formCard.commitInfo);
            com.baidu.tieba.recapp.a.b.bof().a(new com.baidu.tieba.recapp.a.a(this.gFB.getPostUrl()));
            boI();
            boK();
            boJ();
            a(this.gFA);
            a(this.gFB);
            if (formCard.isCommitSuccess()) {
                boM();
            }
            if (!formCard.mHasShown) {
                r.boe().boa().aw(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cy(int i, int i2) {
        this.bHM = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.bHM;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gFK = (float) (this.mScreenWidth / 750.0d);
    }

    private void boI() {
        this.mRootView.setBackgroundResource(d.f.form_defalut_bg_image);
        if (this.gFH.backgroundInfo != null) {
            this.gFE.setVisibility(0);
            if (!TextUtils.isEmpty(this.gFH.backgroundInfo.img)) {
                com.baidu.adp.lib.f.c.nm().a(this.gFH.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.c.2
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
                                        switch (c.this.gFH.backgroundInfo.mode) {
                                            case 1:
                                                c.this.gFE.getLayoutParams().width = c.this.mScreenWidth;
                                                c.this.gFE.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                c.this.gFE.getLayoutParams().width = c.this.mScreenWidth;
                                                c.this.gFE.getLayoutParams().height = c.this.bHM;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(c.this.gFH.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.ra(parseColor)) {
                                            c.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(c.this.gFE);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                c.this.gFE.setImageBitmap(null);
                                c.this.gFE.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                c.this.gFE.setImageBitmap(null);
                                c.this.gFE.setVisibility(8);
                                return;
                            }
                        }
                        c.this.gFE.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gFE.setVisibility(8);
    }

    private void boJ() {
        FormCard.f fVar = this.gFH.resultInfo;
        float dimension = this.aRG.getResources().getDimension(d.e.fontsize48);
        float dimension2 = this.aRG.getResources().getDimension(d.e.fontsize28);
        int color = this.aRG.getResources().getColor(d.C0141d.form_font_color);
        if (fVar != null) {
            this.gFF.setText(fVar.title);
            this.gFF.setTextColor(-1);
            this.gFF.setTextSize(0, dimension);
            this.gFG.setText(fVar.desc);
            this.gFG.setTextColor(color);
            this.gFG.setTextSize(0, dimension2);
        }
    }

    private void boK() {
        if (this.gFH.itemList != null && this.gFH.itemList.size() > 0) {
            int size = this.gFH.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gFH.itemList.get(i);
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

    private void boL() {
        this.gFD.removeAllViews();
        if (this.gFI != null) {
            this.gFI.clear();
        } else {
            this.gFI = new ArrayList();
        }
        this.gFB.setVisibility(0);
        this.gFD.setVisibility(0);
        this.gFC.setVisibility(8);
        this.gFB.setClickable(true);
        this.gFE.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aD(this.gFK);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gFD.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.boN());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size40)) * this.gFK);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.boN()));
        }
    }

    public void a(a aVar) {
        if (this.gFI == null) {
            this.gFI = new ArrayList();
        }
        this.gFI.add(aVar);
    }

    public void b(List<a> list, String str, String str2) {
        JSONObject bR;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.boE()) {
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
                this.gFB.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.e().showToast(d.f.icon_toast_game_error, d.j.form_commit_error_string);
            this.gFB.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boM() {
        this.gFB.setVisibility(4);
        this.gFD.setVisibility(4);
        this.gFC.setVisibility(0);
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
            this.gFB.setClickable(true);
        } else {
            com.baidu.tieba.recapp.a.b.bof().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.c.3
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.aGS) {
                            c.this.gFH.setCommitState(true);
                            c.this.boM();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.e().r(hVar.errorString);
                            c.this.gFH.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.e().showToast(d.f.icon_toast_game_error, d.j.form_commit_fail_string);
                            c.this.gFH.setCommitState(false);
                        }
                    }
                    c.this.gFB.setClickable(true);
                }
            });
        }
    }
}
