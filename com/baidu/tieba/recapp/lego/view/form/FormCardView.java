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
import com.baidu.tbadk.a.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.d;
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
    private int aSH;
    private TitleView gaM;
    private CommitView gaN;
    private LinearLayout gaO;
    private LinearLayout gaP;
    private ImageView gaQ;
    private TextView gaR;
    private TextView gaS;
    private FormCard gaT;
    private List<a> gaU;
    private String gaV;
    private float gaW;
    private int gaX;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean bjL();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gaV = "";
        this.mScreenWidth = 0;
        this.aSH = 0;
        this.gaW = 1.0f;
        this.gaX = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aKU() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.i.card_form, (ViewGroup) null);
        this.gaM = (TitleView) this.mRootView.findViewById(d.g.form_title_view);
        this.gaQ = (ImageView) this.mRootView.findViewById(d.g.tb_img_background);
        this.gaQ.setEnabled(false);
        this.gaN = (CommitView) this.mRootView.findViewById(d.g.form_commit_view);
        this.gaP = (LinearLayout) this.mRootView.findViewById(d.g.item_content_view);
        this.gaO = (LinearLayout) this.mRootView.findViewById(d.g.form_commit_success_view);
        this.gaR = (TextView) this.mRootView.findViewById(d.g.form_success_title);
        this.gaS = (TextView) this.mRootView.findViewById(d.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gaN != null) {
            this.gaN.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    FormCardView.this.b(FormCardView.this.gaU, FormCardView.this.gaN.getPostUrl(), FormCardView.this.gaV);
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
        if (formCard != null && formCard.mIsLegal && this.gaT != formCard) {
            bjS();
            this.gaT = formCard;
            this.gaV = formCard.getItemId();
            bz(formCard.mWidth, formCard.mHeight);
            this.gaM.ar(this.gaW);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gaM.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.gaW);
            }
            this.gaN.ar(this.gaW);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gaN.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.gaW);
            }
            this.gaM.a(formCard.titleInfo);
            this.gaN.a(formCard.commitInfo);
            b.bjm().a(new com.baidu.tieba.recapp.a.a(this.gaN.getPostUrl()));
            bjP();
            bjR();
            bjQ();
            a(this.gaM);
            a(this.gaN);
            if (formCard.isCommitSuccess()) {
                bjT();
            }
            if (!formCard.mHasShown) {
                r.bjl().bjh().aw(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void bz(int i, int i2) {
        this.aSH = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.aSH;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gaW = (float) (this.mScreenWidth / 750.0d);
    }

    private void bjP() {
        this.mRootView.setBackgroundResource(d.f.form_defalut_bg_image);
        if (this.gaT.backgroundInfo != null) {
            this.gaQ.setVisibility(0);
            if (!TextUtils.isEmpty(this.gaT.backgroundInfo.img)) {
                c.fp().a(this.gaT.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.km() != null) {
                                    int height = aVar.km().getHeight();
                                    int width = aVar.km().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.gaT.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.gaQ.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gaQ.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.gaQ.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gaQ.getLayoutParams().height = FormCardView.this.aSH;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.gaT.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.ov(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.gaQ);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.gaQ.setImageBitmap(null);
                                FormCardView.this.gaQ.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.gaQ.setImageBitmap(null);
                                FormCardView.this.gaQ.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.gaQ.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gaQ.setVisibility(8);
    }

    private void bjQ() {
        FormCard.f fVar = this.gaT.resultInfo;
        float dimension = this.adf.getResources().getDimension(d.e.fontsize48);
        float dimension2 = this.adf.getResources().getDimension(d.e.fontsize28);
        int color = this.adf.getResources().getColor(d.C0126d.form_font_color);
        if (fVar != null) {
            this.gaR.setText(fVar.title);
            this.gaR.setTextColor(-1);
            this.gaR.setTextSize(0, dimension);
            this.gaS.setText(fVar.desc);
            this.gaS.setTextColor(color);
            this.gaS.setTextSize(0, dimension2);
        }
    }

    private void bjR() {
        if (this.gaT.itemList != null && this.gaT.itemList.size() > 0) {
            int size = this.gaT.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gaT.itemList.get(i);
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

    private void bjS() {
        this.gaP.removeAllViews();
        if (this.gaU != null) {
            this.gaU.clear();
        } else {
            this.gaU = new ArrayList();
        }
        this.gaN.setVisibility(0);
        this.gaP.setVisibility(0);
        this.gaO.setVisibility(8);
        this.gaN.setClickable(true);
        this.gaQ.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.ar(this.gaW);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gaP.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.bjU());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size40)) * this.gaW);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.bjU()));
        }
    }

    public void a(a aVar) {
        if (this.gaU == null) {
            this.gaU = new ArrayList();
        }
        this.gaU.add(aVar);
    }

    public void b(List<a> list, String str, String str2) {
        JSONObject bQ;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.bjL()) {
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
                    if (formView2 != null && (bQ = bQ(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(bQ);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                a(str, hashMap);
                this.gaN.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.b().showToast(d.f.icon_toast_game_error, d.k.form_commit_error_string);
            this.gaN.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjT() {
        this.gaN.setVisibility(4);
        this.gaP.setVisibility(4);
        this.gaO.setVisibility(0);
    }

    private JSONObject bQ(String str, String str2) {
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

    private void a(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.gaN.setClickable(true);
        } else {
            b.bjm().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.Sd) {
                            FormCardView.this.gaT.setCommitState(true);
                            FormCardView.this.bjT();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.b().j(hVar.errorString);
                            FormCardView.this.gaT.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.b().showToast(d.f.icon_toast_game_error, d.k.form_commit_fail_string);
                            FormCardView.this.gaT.setCommitState(false);
                        }
                    }
                    FormCardView.this.gaN.setClickable(true);
                }
            });
        }
    }
}
