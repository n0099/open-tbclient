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
    private int boq;
    private CommitView gTA;
    private LinearLayout gTB;
    private LinearLayout gTC;
    private ImageView gTD;
    private TextView gTE;
    private TextView gTF;
    private FormCard gTG;
    private List<a> gTH;
    private String gTI;
    private float gTJ;
    private int gTK;
    private TitleView gTz;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean bwu();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gTI = "";
        this.mScreenWidth = 0;
        this.boq = 0;
        this.gTJ = 1.0f;
        this.gTK = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aZy() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(e.h.card_form, (ViewGroup) null);
        this.gTz = (TitleView) this.mRootView.findViewById(e.g.form_title_view);
        this.gTD = (ImageView) this.mRootView.findViewById(e.g.tb_img_background);
        this.gTD.setEnabled(false);
        this.gTA = (CommitView) this.mRootView.findViewById(e.g.form_commit_view);
        this.gTC = (LinearLayout) this.mRootView.findViewById(e.g.item_content_view);
        this.gTB = (LinearLayout) this.mRootView.findViewById(e.g.form_commit_success_view);
        this.gTE = (TextView) this.mRootView.findViewById(e.g.form_success_title);
        this.gTF = (TextView) this.mRootView.findViewById(e.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gTA != null) {
            this.gTA.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.gTH, FormCardView.this.gTA.getPostUrl(), FormCardView.this.gTI);
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
        if (formCard != null && formCard.mIsLegal && this.gTG != formCard) {
            bwB();
            this.gTG = formCard;
            this.gTI = formCard.getItemId();
            bH(formCard.mWidth, formCard.mHeight);
            this.gTz.ay(this.gTJ);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gTz.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0210e.form_size90)) * this.gTJ);
            }
            this.gTA.ay(this.gTJ);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gTA.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0210e.form_size90)) * this.gTJ);
            }
            this.gTz.a(formCard.titleInfo);
            this.gTA.a(formCard.commitInfo);
            b.bvU().a(new com.baidu.tieba.recapp.a.a(this.gTA.getPostUrl()));
            bwy();
            bwA();
            bwz();
            a(this.gTz);
            a(this.gTA);
            if (formCard.isCommitSuccess()) {
                bwC();
            }
            if (!formCard.mHasShown) {
                r.bvT().bvP().aV(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void bH(int i, int i2) {
        this.boq = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.boq;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gTJ = (float) (this.mScreenWidth / 750.0d);
    }

    private void bwy() {
        this.mRootView.setBackgroundResource(e.f.form_defalut_bg_image);
        if (this.gTG.backgroundInfo != null) {
            this.gTD.setVisibility(0);
            if (!TextUtils.isEmpty(this.gTG.backgroundInfo.img)) {
                c.jA().a(this.gTG.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.ot() != null) {
                                    int height = aVar.ot().getHeight();
                                    int width = aVar.ot().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.gTG.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.gTD.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gTD.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.gTD.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gTD.getLayoutParams().height = FormCardView.this.boq;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.gTG.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.rg(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.gTD);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.gTD.setImageBitmap(null);
                                FormCardView.this.gTD.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.gTD.setImageBitmap(null);
                                FormCardView.this.gTD.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.gTD.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gTD.setVisibility(8);
    }

    private void bwz() {
        FormCard.f fVar = this.gTG.resultInfo;
        float dimension = this.mContext.getResources().getDimension(e.C0210e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(e.C0210e.fontsize28);
        int color = this.mContext.getResources().getColor(e.d.form_font_color);
        if (fVar != null) {
            this.gTE.setText(fVar.title);
            this.gTE.setTextColor(-1);
            this.gTE.setTextSize(0, dimension);
            this.gTF.setText(fVar.desc);
            this.gTF.setTextColor(color);
            this.gTF.setTextSize(0, dimension2);
        }
    }

    private void bwA() {
        if (this.gTG.itemList != null && this.gTG.itemList.size() > 0) {
            int size = this.gTG.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gTG.itemList.get(i);
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

    private void bwB() {
        this.gTC.removeAllViews();
        if (this.gTH != null) {
            this.gTH.clear();
        } else {
            this.gTH = new ArrayList();
        }
        this.gTA.setVisibility(0);
        this.gTC.setVisibility(0);
        this.gTB.setVisibility(8);
        this.gTA.setClickable(true);
        this.gTD.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.ay(this.gTJ);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gTC.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.bwD());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0210e.form_size40)) * this.gTJ);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.bwD()));
        }
    }

    public void a(a aVar) {
        if (this.gTH == null) {
            this.gTH = new ArrayList();
        }
        this.gTH.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject cA;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.bwu()) {
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
                    if (formView2 != null && (cA = cA(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(cA);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                c(str, hashMap);
                this.gTA.setClickable(false);
                return;
            }
            new g().showToast(e.f.icon_toast_game_error, e.j.form_commit_error_string);
            this.gTA.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwC() {
        this.gTA.setVisibility(4);
        this.gTC.setVisibility(4);
        this.gTB.setVisibility(0);
    }

    private JSONObject cA(String str, String str2) {
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
            this.gTA.setClickable(true);
        } else {
            b.bvU().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.amb) {
                            FormCardView.this.gTG.setCommitState(true);
                            FormCardView.this.bwC();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new g().f(hVar.errorString);
                            FormCardView.this.gTG.setCommitState(false);
                        } else {
                            new g().showToast(e.f.icon_toast_game_error, e.j.form_commit_fail_string);
                            FormCardView.this.gTG.setCommitState(false);
                        }
                    }
                    FormCardView.this.gTA.setClickable(true);
                }
            });
        }
    }
}
