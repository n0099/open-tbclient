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
    private int beZ;
    private TitleView gzK;
    private CommitView gzL;
    private LinearLayout gzM;
    private LinearLayout gzN;
    private ImageView gzO;
    private TextView gzP;
    private TextView gzQ;
    private FormCard gzR;
    private List<a> gzS;
    private String gzT;
    private float gzU;
    private int gzV;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean bqw();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gzT = "";
        this.mScreenWidth = 0;
        this.beZ = 0;
        this.gzU = 1.0f;
        this.gzV = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aTI() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(e.h.card_form, (ViewGroup) null);
        this.gzK = (TitleView) this.mRootView.findViewById(e.g.form_title_view);
        this.gzO = (ImageView) this.mRootView.findViewById(e.g.tb_img_background);
        this.gzO.setEnabled(false);
        this.gzL = (CommitView) this.mRootView.findViewById(e.g.form_commit_view);
        this.gzN = (LinearLayout) this.mRootView.findViewById(e.g.item_content_view);
        this.gzM = (LinearLayout) this.mRootView.findViewById(e.g.form_commit_success_view);
        this.gzP = (TextView) this.mRootView.findViewById(e.g.form_success_title);
        this.gzQ = (TextView) this.mRootView.findViewById(e.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gzL != null) {
            this.gzL.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.gzS, FormCardView.this.gzL.getPostUrl(), FormCardView.this.gzT);
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
        if (formCard != null && formCard.mIsLegal && this.gzR != formCard) {
            bqD();
            this.gzR = formCard;
            this.gzT = formCard.getItemId();
            bD(formCard.mWidth, formCard.mHeight);
            this.gzK.av(this.gzU);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gzK.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0141e.form_size90)) * this.gzU);
            }
            this.gzL.av(this.gzU);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gzL.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0141e.form_size90)) * this.gzU);
            }
            this.gzK.a(formCard.titleInfo);
            this.gzL.a(formCard.commitInfo);
            b.bpW().a(new com.baidu.tieba.recapp.a.a(this.gzL.getPostUrl()));
            bqA();
            bqC();
            bqB();
            a(this.gzK);
            a(this.gzL);
            if (formCard.isCommitSuccess()) {
                bqE();
            }
            if (!formCard.mHasShown) {
                r.bpV().bpR().aH(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void bD(int i, int i2) {
        this.beZ = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.beZ;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gzU = (float) (this.mScreenWidth / 750.0d);
    }

    private void bqA() {
        this.mRootView.setBackgroundResource(e.f.form_defalut_bg_image);
        if (this.gzR.backgroundInfo != null) {
            this.gzO.setVisibility(0);
            if (!TextUtils.isEmpty(this.gzR.backgroundInfo.img)) {
                c.jn().a(this.gzR.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.oh() != null) {
                                    int height = aVar.oh().getHeight();
                                    int width = aVar.oh().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.gzR.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.gzO.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gzO.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.gzO.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gzO.getLayoutParams().height = FormCardView.this.beZ;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.gzR.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.pG(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.gzO);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.gzO.setImageBitmap(null);
                                FormCardView.this.gzO.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.gzO.setImageBitmap(null);
                                FormCardView.this.gzO.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.gzO.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gzO.setVisibility(8);
    }

    private void bqB() {
        FormCard.f fVar = this.gzR.resultInfo;
        float dimension = this.mContext.getResources().getDimension(e.C0141e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(e.C0141e.fontsize28);
        int color = this.mContext.getResources().getColor(e.d.form_font_color);
        if (fVar != null) {
            this.gzP.setText(fVar.title);
            this.gzP.setTextColor(-1);
            this.gzP.setTextSize(0, dimension);
            this.gzQ.setText(fVar.desc);
            this.gzQ.setTextColor(color);
            this.gzQ.setTextSize(0, dimension2);
        }
    }

    private void bqC() {
        if (this.gzR.itemList != null && this.gzR.itemList.size() > 0) {
            int size = this.gzR.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gzR.itemList.get(i);
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

    private void bqD() {
        this.gzN.removeAllViews();
        if (this.gzS != null) {
            this.gzS.clear();
        } else {
            this.gzS = new ArrayList();
        }
        this.gzL.setVisibility(0);
        this.gzN.setVisibility(0);
        this.gzM.setVisibility(8);
        this.gzL.setClickable(true);
        this.gzO.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.av(this.gzU);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gzN.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.bqF());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(e.C0141e.form_size40)) * this.gzU);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.bqF()));
        }
    }

    public void a(a aVar) {
        if (this.gzS == null) {
            this.gzS = new ArrayList();
        }
        this.gzS.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject cj;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.bqw()) {
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
                    if (formView2 != null && (cj = cj(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(cj);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                c(str, hashMap);
                this.gzL.setClickable(false);
                return;
            }
            new g().showToast(e.f.icon_toast_game_error, e.j.form_commit_error_string);
            this.gzL.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqE() {
        this.gzL.setVisibility(4);
        this.gzN.setVisibility(4);
        this.gzM.setVisibility(0);
    }

    private JSONObject cj(String str, String str2) {
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
            this.gzL.setClickable(true);
        } else {
            b.bpW().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void j(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.act) {
                            FormCardView.this.gzR.setCommitState(true);
                            FormCardView.this.bqE();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new g().f(hVar.errorString);
                            FormCardView.this.gzR.setCommitState(false);
                        } else {
                            new g().showToast(e.f.icon_toast_game_error, e.j.form_commit_fail_string);
                            FormCardView.this.gzR.setCommitState(false);
                        }
                    }
                    FormCardView.this.gzL.setClickable(true);
                }
            });
        }
    }
}
