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
    private int bnz;
    private TitleView gPC;
    private CommitView gPD;
    private LinearLayout gPE;
    private LinearLayout gPF;
    private ImageView gPG;
    private TextView gPH;
    private TextView gPI;
    private FormCard gPJ;
    private List<a> gPK;
    private String gPL;
    private float gPM;
    private int gPN;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean buZ();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gPL = "";
        this.mScreenWidth = 0;
        this.bnz = 0;
        this.gPM = 1.0f;
        this.gPN = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aYk() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(e.h.card_form, (ViewGroup) null);
        this.gPC = (TitleView) this.mRootView.findViewById(e.g.form_title_view);
        this.gPG = (ImageView) this.mRootView.findViewById(e.g.tb_img_background);
        this.gPG.setEnabled(false);
        this.gPD = (CommitView) this.mRootView.findViewById(e.g.form_commit_view);
        this.gPF = (LinearLayout) this.mRootView.findViewById(e.g.item_content_view);
        this.gPE = (LinearLayout) this.mRootView.findViewById(e.g.form_commit_success_view);
        this.gPH = (TextView) this.mRootView.findViewById(e.g.form_success_title);
        this.gPI = (TextView) this.mRootView.findViewById(e.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gPD != null) {
            this.gPD.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.gPK, FormCardView.this.gPD.getPostUrl(), FormCardView.this.gPL);
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
        if (formCard != null && formCard.mIsLegal && this.gPJ != formCard) {
            bvg();
            this.gPJ = formCard;
            this.gPL = formCard.getItemId();
            bG(formCard.mWidth, formCard.mHeight);
            this.gPC.ay(this.gPM);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gPC.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0210e.form_size90)) * this.gPM);
            }
            this.gPD.ay(this.gPM);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gPD.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0210e.form_size90)) * this.gPM);
            }
            this.gPC.a(formCard.titleInfo);
            this.gPD.a(formCard.commitInfo);
            b.buz().a(new com.baidu.tieba.recapp.a.a(this.gPD.getPostUrl()));
            bvd();
            bvf();
            bve();
            a(this.gPC);
            a(this.gPD);
            if (formCard.isCommitSuccess()) {
                bvh();
            }
            if (!formCard.mHasShown) {
                r.buy().buu().aU(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void bG(int i, int i2) {
        this.bnz = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.bnz;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gPM = (float) (this.mScreenWidth / 750.0d);
    }

    private void bvd() {
        this.mRootView.setBackgroundResource(e.f.form_defalut_bg_image);
        if (this.gPJ.backgroundInfo != null) {
            this.gPG.setVisibility(0);
            if (!TextUtils.isEmpty(this.gPJ.backgroundInfo.img)) {
                c.jA().a(this.gPJ.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.op() != null) {
                                    int height = aVar.op().getHeight();
                                    int width = aVar.op().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.gPJ.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.gPG.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gPG.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.gPG.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gPG.getLayoutParams().height = FormCardView.this.bnz;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.gPJ.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.qR(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.gPG);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.gPG.setImageBitmap(null);
                                FormCardView.this.gPG.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.gPG.setImageBitmap(null);
                                FormCardView.this.gPG.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.gPG.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gPG.setVisibility(8);
    }

    private void bve() {
        FormCard.f fVar = this.gPJ.resultInfo;
        float dimension = this.mContext.getResources().getDimension(e.C0210e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(e.C0210e.fontsize28);
        int color = this.mContext.getResources().getColor(e.d.form_font_color);
        if (fVar != null) {
            this.gPH.setText(fVar.title);
            this.gPH.setTextColor(-1);
            this.gPH.setTextSize(0, dimension);
            this.gPI.setText(fVar.desc);
            this.gPI.setTextColor(color);
            this.gPI.setTextSize(0, dimension2);
        }
    }

    private void bvf() {
        if (this.gPJ.itemList != null && this.gPJ.itemList.size() > 0) {
            int size = this.gPJ.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gPJ.itemList.get(i);
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

    private void bvg() {
        this.gPF.removeAllViews();
        if (this.gPK != null) {
            this.gPK.clear();
        } else {
            this.gPK = new ArrayList();
        }
        this.gPD.setVisibility(0);
        this.gPF.setVisibility(0);
        this.gPE.setVisibility(8);
        this.gPD.setClickable(true);
        this.gPG.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.ay(this.gPM);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gPF.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.bvi());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0210e.form_size40)) * this.gPM);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.bvi()));
        }
    }

    public void a(a aVar) {
        if (this.gPK == null) {
            this.gPK = new ArrayList();
        }
        this.gPK.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject cz;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.buZ()) {
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
                    if (formView2 != null && (cz = cz(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(cz);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                c(str, hashMap);
                this.gPD.setClickable(false);
                return;
            }
            new g().showToast(e.f.icon_toast_game_error, e.j.form_commit_error_string);
            this.gPD.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvh() {
        this.gPD.setVisibility(4);
        this.gPF.setVisibility(4);
        this.gPE.setVisibility(0);
    }

    private JSONObject cz(String str, String str2) {
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
            this.gPD.setClickable(true);
        } else {
            b.buz().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.alH) {
                            FormCardView.this.gPJ.setCommitState(true);
                            FormCardView.this.bvh();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new g().f(hVar.errorString);
                            FormCardView.this.gPJ.setCommitState(false);
                        } else {
                            new g().showToast(e.f.icon_toast_game_error, e.j.form_commit_fail_string);
                            FormCardView.this.gPJ.setCommitState(false);
                        }
                    }
                    FormCardView.this.gPD.setClickable(true);
                }
            });
        }
    }
}
