package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
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
    private int cyR;
    private TitleView ikI;
    private CommitView ikJ;
    private LinearLayout ikK;
    private LinearLayout ikL;
    private ImageView ikM;
    private TextView ikN;
    private TextView ikO;
    private FormCard ikP;
    private List<a> ikQ;
    private String ikR;
    private float ikS;
    private int ikT;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean bXg();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ikR = "";
        this.mScreenWidth = 0;
        this.cyR = 0;
        this.ikS = 1.0f;
        this.ikT = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAa() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.h.card_form, (ViewGroup) null);
        this.ikI = (TitleView) this.mRootView.findViewById(d.g.form_title_view);
        this.ikM = (ImageView) this.mRootView.findViewById(d.g.tb_img_background);
        this.ikM.setEnabled(false);
        this.ikJ = (CommitView) this.mRootView.findViewById(d.g.form_commit_view);
        this.ikL = (LinearLayout) this.mRootView.findViewById(d.g.item_content_view);
        this.ikK = (LinearLayout) this.mRootView.findViewById(d.g.form_commit_success_view);
        this.ikN = (TextView) this.mRootView.findViewById(d.g.form_success_title);
        this.ikO = (TextView) this.mRootView.findViewById(d.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.ikJ != null) {
            this.ikJ.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.ikQ, FormCardView.this.ikJ.getPostUrl(), FormCardView.this.ikR);
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
        if (formCard != null && formCard.mIsLegal && this.ikP != formCard) {
            bXn();
            this.ikP = formCard;
            this.ikR = formCard.getItemId();
            cd(formCard.mWidth, formCard.mHeight);
            this.ikI.aL(this.ikS);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ikI.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.ikS);
            }
            this.ikJ.aL(this.ikS);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ikJ.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.ikS);
            }
            this.ikI.a(formCard.titleInfo);
            this.ikJ.a(formCard.commitInfo);
            b.bWG().a(new com.baidu.tieba.recapp.a.a(this.ikJ.getPostUrl()));
            bXk();
            bXm();
            bXl();
            a(this.ikI);
            a(this.ikJ);
            if (formCard.isCommitSuccess()) {
                bXo();
            }
            if (!formCard.mHasShown) {
                r.bWF().bWB().ca(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cd(int i, int i2) {
        this.cyR = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.cyR;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.ikS = (float) (this.mScreenWidth / 750.0d);
    }

    private void bXk() {
        this.mRootView.setBackgroundResource(d.f.form_defalut_bg_image);
        if (this.ikP.backgroundInfo != null) {
            this.ikM.setVisibility(0);
            if (!TextUtils.isEmpty(this.ikP.backgroundInfo.img)) {
                c.jB().a(this.ikP.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.oy() != null) {
                                    int height = aVar.oy().getHeight();
                                    int width = aVar.oy().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.ikP.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.ikM.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.ikM.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.ikM.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.ikM.getLayoutParams().height = FormCardView.this.cyR;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.ikP.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.uL(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.ikM);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.ikM.setImageBitmap(null);
                                FormCardView.this.ikM.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.ikM.setImageBitmap(null);
                                FormCardView.this.ikM.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.ikM.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.ikM.setVisibility(8);
    }

    private void bXl() {
        FormCard.f fVar = this.ikP.resultInfo;
        float dimension = this.mContext.getResources().getDimension(d.e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(d.e.fontsize28);
        int color = this.mContext.getResources().getColor(d.C0277d.form_font_color);
        if (fVar != null) {
            this.ikN.setText(fVar.title);
            this.ikN.setTextColor(-1);
            this.ikN.setTextSize(0, dimension);
            this.ikO.setText(fVar.desc);
            this.ikO.setTextColor(color);
            this.ikO.setTextSize(0, dimension2);
        }
    }

    private void bXm() {
        if (this.ikP.itemList != null && this.ikP.itemList.size() > 0) {
            int size = this.ikP.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.ikP.itemList.get(i);
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

    private void bXn() {
        this.ikL.removeAllViews();
        if (this.ikQ != null) {
            this.ikQ.clear();
        } else {
            this.ikQ = new ArrayList();
        }
        this.ikJ.setVisibility(0);
        this.ikL.setVisibility(0);
        this.ikK.setVisibility(8);
        this.ikJ.setClickable(true);
        this.ikM.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aL(this.ikS);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.ikL.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.bXp());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size40)) * this.ikS);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.bXp()));
        }
    }

    public void a(a aVar) {
        if (this.ikQ == null) {
            this.ikQ = new ArrayList();
        }
        this.ikQ.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject dK;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.bXg()) {
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
                    if (formView2 != null && (dK = dK(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(dK);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                d(str, hashMap);
                this.ikJ.setClickable(false);
                return;
            }
            new e().showToast(d.f.icon_toast_game_error, d.j.form_commit_error_string);
            this.ikJ.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXo() {
        this.ikJ.setVisibility(4);
        this.ikL.setVisibility(4);
        this.ikK.setVisibility(0);
    }

    private JSONObject dK(String str, String str2) {
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

    private void d(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.ikJ.setClickable(true);
        } else {
            b.bWG().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.ikP.setCommitState(true);
                            FormCardView.this.bXo();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new e().j(hVar.errorString);
                            FormCardView.this.ikP.setCommitState(false);
                        } else {
                            new e().showToast(d.f.icon_toast_game_error, d.j.form_commit_fail_string);
                            FormCardView.this.ikP.setCommitState(false);
                        }
                    }
                    FormCardView.this.ikJ.setClickable(true);
                }
            });
        }
    }
}
