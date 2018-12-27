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
    private int bnC;
    private TextView gSA;
    private FormCard gSB;
    private List<a> gSC;
    private String gSD;
    private float gSE;
    private int gSF;
    private TitleView gSu;
    private CommitView gSv;
    private LinearLayout gSw;
    private LinearLayout gSx;
    private ImageView gSy;
    private TextView gSz;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean bvL();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gSD = "";
        this.mScreenWidth = 0;
        this.bnC = 0;
        this.gSE = 1.0f;
        this.gSF = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aYY() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(e.h.card_form, (ViewGroup) null);
        this.gSu = (TitleView) this.mRootView.findViewById(e.g.form_title_view);
        this.gSy = (ImageView) this.mRootView.findViewById(e.g.tb_img_background);
        this.gSy.setEnabled(false);
        this.gSv = (CommitView) this.mRootView.findViewById(e.g.form_commit_view);
        this.gSx = (LinearLayout) this.mRootView.findViewById(e.g.item_content_view);
        this.gSw = (LinearLayout) this.mRootView.findViewById(e.g.form_commit_success_view);
        this.gSz = (TextView) this.mRootView.findViewById(e.g.form_success_title);
        this.gSA = (TextView) this.mRootView.findViewById(e.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gSv != null) {
            this.gSv.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.gSC, FormCardView.this.gSv.getPostUrl(), FormCardView.this.gSD);
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
        if (formCard != null && formCard.mIsLegal && this.gSB != formCard) {
            bvS();
            this.gSB = formCard;
            this.gSD = formCard.getItemId();
            bH(formCard.mWidth, formCard.mHeight);
            this.gSu.ay(this.gSE);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gSu.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0210e.form_size90)) * this.gSE);
            }
            this.gSv.ay(this.gSE);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gSv.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0210e.form_size90)) * this.gSE);
            }
            this.gSu.a(formCard.titleInfo);
            this.gSv.a(formCard.commitInfo);
            b.bvl().a(new com.baidu.tieba.recapp.a.a(this.gSv.getPostUrl()));
            bvP();
            bvR();
            bvQ();
            a(this.gSu);
            a(this.gSv);
            if (formCard.isCommitSuccess()) {
                bvT();
            }
            if (!formCard.mHasShown) {
                r.bvk().bvg().aU(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void bH(int i, int i2) {
        this.bnC = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.bnC;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gSE = (float) (this.mScreenWidth / 750.0d);
    }

    private void bvP() {
        this.mRootView.setBackgroundResource(e.f.form_defalut_bg_image);
        if (this.gSB.backgroundInfo != null) {
            this.gSy.setVisibility(0);
            if (!TextUtils.isEmpty(this.gSB.backgroundInfo.img)) {
                c.jA().a(this.gSB.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.gSB.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.gSy.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gSy.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.gSy.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gSy.getLayoutParams().height = FormCardView.this.bnC;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.gSB.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.re(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.gSy);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.gSy.setImageBitmap(null);
                                FormCardView.this.gSy.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.gSy.setImageBitmap(null);
                                FormCardView.this.gSy.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.gSy.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gSy.setVisibility(8);
    }

    private void bvQ() {
        FormCard.f fVar = this.gSB.resultInfo;
        float dimension = this.mContext.getResources().getDimension(e.C0210e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(e.C0210e.fontsize28);
        int color = this.mContext.getResources().getColor(e.d.form_font_color);
        if (fVar != null) {
            this.gSz.setText(fVar.title);
            this.gSz.setTextColor(-1);
            this.gSz.setTextSize(0, dimension);
            this.gSA.setText(fVar.desc);
            this.gSA.setTextColor(color);
            this.gSA.setTextSize(0, dimension2);
        }
    }

    private void bvR() {
        if (this.gSB.itemList != null && this.gSB.itemList.size() > 0) {
            int size = this.gSB.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gSB.itemList.get(i);
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

    private void bvS() {
        this.gSx.removeAllViews();
        if (this.gSC != null) {
            this.gSC.clear();
        } else {
            this.gSC = new ArrayList();
        }
        this.gSv.setVisibility(0);
        this.gSx.setVisibility(0);
        this.gSw.setVisibility(8);
        this.gSv.setClickable(true);
        this.gSy.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.ay(this.gSE);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gSx.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.bvU());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0210e.form_size40)) * this.gSE);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.bvU()));
        }
    }

    public void a(a aVar) {
        if (this.gSC == null) {
            this.gSC = new ArrayList();
        }
        this.gSC.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject cz;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.bvL()) {
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
                this.gSv.setClickable(false);
                return;
            }
            new g().showToast(e.f.icon_toast_game_error, e.j.form_commit_error_string);
            this.gSv.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvT() {
        this.gSv.setVisibility(4);
        this.gSx.setVisibility(4);
        this.gSw.setVisibility(0);
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
            this.gSv.setClickable(true);
        } else {
            b.bvl().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.alH) {
                            FormCardView.this.gSB.setCommitState(true);
                            FormCardView.this.bvT();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new g().f(hVar.errorString);
                            FormCardView.this.gSB.setCommitState(false);
                        } else {
                            new g().showToast(e.f.icon_toast_game_error, e.j.form_commit_fail_string);
                            FormCardView.this.gSB.setCommitState(false);
                        }
                    }
                    FormCardView.this.gSv.setClickable(true);
                }
            });
        }
    }
}
