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
    private int bor;
    private TitleView gTA;
    private CommitView gTB;
    private LinearLayout gTC;
    private LinearLayout gTD;
    private ImageView gTE;
    private TextView gTF;
    private TextView gTG;
    private FormCard gTH;
    private List<a> gTI;
    private String gTJ;
    private float gTK;
    private int gTL;
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
        this.gTJ = "";
        this.mScreenWidth = 0;
        this.bor = 0;
        this.gTK = 1.0f;
        this.gTL = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aZy() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(e.h.card_form, (ViewGroup) null);
        this.gTA = (TitleView) this.mRootView.findViewById(e.g.form_title_view);
        this.gTE = (ImageView) this.mRootView.findViewById(e.g.tb_img_background);
        this.gTE.setEnabled(false);
        this.gTB = (CommitView) this.mRootView.findViewById(e.g.form_commit_view);
        this.gTD = (LinearLayout) this.mRootView.findViewById(e.g.item_content_view);
        this.gTC = (LinearLayout) this.mRootView.findViewById(e.g.form_commit_success_view);
        this.gTF = (TextView) this.mRootView.findViewById(e.g.form_success_title);
        this.gTG = (TextView) this.mRootView.findViewById(e.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gTB != null) {
            this.gTB.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.gTI, FormCardView.this.gTB.getPostUrl(), FormCardView.this.gTJ);
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
        if (formCard != null && formCard.mIsLegal && this.gTH != formCard) {
            bwB();
            this.gTH = formCard;
            this.gTJ = formCard.getItemId();
            bH(formCard.mWidth, formCard.mHeight);
            this.gTA.ay(this.gTK);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gTA.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0210e.form_size90)) * this.gTK);
            }
            this.gTB.ay(this.gTK);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gTB.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0210e.form_size90)) * this.gTK);
            }
            this.gTA.a(formCard.titleInfo);
            this.gTB.a(formCard.commitInfo);
            b.bvU().a(new com.baidu.tieba.recapp.a.a(this.gTB.getPostUrl()));
            bwy();
            bwA();
            bwz();
            a(this.gTA);
            a(this.gTB);
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
        this.bor = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.bor;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gTK = (float) (this.mScreenWidth / 750.0d);
    }

    private void bwy() {
        this.mRootView.setBackgroundResource(e.f.form_defalut_bg_image);
        if (this.gTH.backgroundInfo != null) {
            this.gTE.setVisibility(0);
            if (!TextUtils.isEmpty(this.gTH.backgroundInfo.img)) {
                c.jA().a(this.gTH.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.gTH.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.gTE.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gTE.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.gTE.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gTE.getLayoutParams().height = FormCardView.this.bor;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.gTH.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.rg(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.gTE);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.gTE.setImageBitmap(null);
                                FormCardView.this.gTE.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.gTE.setImageBitmap(null);
                                FormCardView.this.gTE.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.gTE.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gTE.setVisibility(8);
    }

    private void bwz() {
        FormCard.f fVar = this.gTH.resultInfo;
        float dimension = this.mContext.getResources().getDimension(e.C0210e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(e.C0210e.fontsize28);
        int color = this.mContext.getResources().getColor(e.d.form_font_color);
        if (fVar != null) {
            this.gTF.setText(fVar.title);
            this.gTF.setTextColor(-1);
            this.gTF.setTextSize(0, dimension);
            this.gTG.setText(fVar.desc);
            this.gTG.setTextColor(color);
            this.gTG.setTextSize(0, dimension2);
        }
    }

    private void bwA() {
        if (this.gTH.itemList != null && this.gTH.itemList.size() > 0) {
            int size = this.gTH.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gTH.itemList.get(i);
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
        this.gTD.removeAllViews();
        if (this.gTI != null) {
            this.gTI.clear();
        } else {
            this.gTI = new ArrayList();
        }
        this.gTB.setVisibility(0);
        this.gTD.setVisibility(0);
        this.gTC.setVisibility(8);
        this.gTB.setClickable(true);
        this.gTE.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.ay(this.gTK);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gTD.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.bwD());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0210e.form_size40)) * this.gTK);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.bwD()));
        }
    }

    public void a(a aVar) {
        if (this.gTI == null) {
            this.gTI = new ArrayList();
        }
        this.gTI.add(aVar);
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
                this.gTB.setClickable(false);
                return;
            }
            new g().showToast(e.f.icon_toast_game_error, e.j.form_commit_error_string);
            this.gTB.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwC() {
        this.gTB.setVisibility(4);
        this.gTD.setVisibility(4);
        this.gTC.setVisibility(0);
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
            this.gTB.setClickable(true);
        } else {
            b.bvU().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.amb) {
                            FormCardView.this.gTH.setCommitState(true);
                            FormCardView.this.bwC();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new g().f(hVar.errorString);
                            FormCardView.this.gTH.setCommitState(false);
                        } else {
                            new g().showToast(e.f.icon_toast_game_error, e.j.form_commit_fail_string);
                            FormCardView.this.gTH.setCommitState(false);
                        }
                    }
                    FormCardView.this.gTB.setClickable(true);
                }
            });
        }
    }
}
