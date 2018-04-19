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
    private TitleView gaP;
    private CommitView gaQ;
    private LinearLayout gaR;
    private LinearLayout gaS;
    private ImageView gaT;
    private TextView gaU;
    private TextView gaV;
    private FormCard gaW;
    private List<a> gaX;
    private String gaY;
    private float gaZ;
    private int gba;
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
        this.gaY = "";
        this.mScreenWidth = 0;
        this.aSH = 0;
        this.gaZ = 1.0f;
        this.gba = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aKU() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.i.card_form, (ViewGroup) null);
        this.gaP = (TitleView) this.mRootView.findViewById(d.g.form_title_view);
        this.gaT = (ImageView) this.mRootView.findViewById(d.g.tb_img_background);
        this.gaT.setEnabled(false);
        this.gaQ = (CommitView) this.mRootView.findViewById(d.g.form_commit_view);
        this.gaS = (LinearLayout) this.mRootView.findViewById(d.g.item_content_view);
        this.gaR = (LinearLayout) this.mRootView.findViewById(d.g.form_commit_success_view);
        this.gaU = (TextView) this.mRootView.findViewById(d.g.form_success_title);
        this.gaV = (TextView) this.mRootView.findViewById(d.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gaQ != null) {
            this.gaQ.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    FormCardView.this.b(FormCardView.this.gaX, FormCardView.this.gaQ.getPostUrl(), FormCardView.this.gaY);
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
        if (formCard != null && formCard.mIsLegal && this.gaW != formCard) {
            bjS();
            this.gaW = formCard;
            this.gaY = formCard.getItemId();
            bA(formCard.mWidth, formCard.mHeight);
            this.gaP.ar(this.gaZ);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gaP.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.gaZ);
            }
            this.gaQ.ar(this.gaZ);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gaQ.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.gaZ);
            }
            this.gaP.a(formCard.titleInfo);
            this.gaQ.a(formCard.commitInfo);
            b.bjm().a(new com.baidu.tieba.recapp.a.a(this.gaQ.getPostUrl()));
            bjP();
            bjR();
            bjQ();
            a(this.gaP);
            a(this.gaQ);
            if (formCard.isCommitSuccess()) {
                bjT();
            }
            if (!formCard.mHasShown) {
                r.bjl().bjh().aw(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void bA(int i, int i2) {
        this.aSH = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.aSH;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gaZ = (float) (this.mScreenWidth / 750.0d);
    }

    private void bjP() {
        this.mRootView.setBackgroundResource(d.f.form_defalut_bg_image);
        if (this.gaW.backgroundInfo != null) {
            this.gaT.setVisibility(0);
            if (!TextUtils.isEmpty(this.gaW.backgroundInfo.img)) {
                c.fp().a(this.gaW.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.gaW.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.gaT.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gaT.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.gaT.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gaT.getLayoutParams().height = FormCardView.this.aSH;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.gaW.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.ov(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.gaT);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.gaT.setImageBitmap(null);
                                FormCardView.this.gaT.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.gaT.setImageBitmap(null);
                                FormCardView.this.gaT.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.gaT.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gaT.setVisibility(8);
    }

    private void bjQ() {
        FormCard.f fVar = this.gaW.resultInfo;
        float dimension = this.adf.getResources().getDimension(d.e.fontsize48);
        float dimension2 = this.adf.getResources().getDimension(d.e.fontsize28);
        int color = this.adf.getResources().getColor(d.C0126d.form_font_color);
        if (fVar != null) {
            this.gaU.setText(fVar.title);
            this.gaU.setTextColor(-1);
            this.gaU.setTextSize(0, dimension);
            this.gaV.setText(fVar.desc);
            this.gaV.setTextColor(color);
            this.gaV.setTextSize(0, dimension2);
        }
    }

    private void bjR() {
        if (this.gaW.itemList != null && this.gaW.itemList.size() > 0) {
            int size = this.gaW.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gaW.itemList.get(i);
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
        this.gaS.removeAllViews();
        if (this.gaX != null) {
            this.gaX.clear();
        } else {
            this.gaX = new ArrayList();
        }
        this.gaQ.setVisibility(0);
        this.gaS.setVisibility(0);
        this.gaR.setVisibility(8);
        this.gaQ.setClickable(true);
        this.gaT.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.ar(this.gaZ);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gaS.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.bjU());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size40)) * this.gaZ);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.bjU()));
        }
    }

    public void a(a aVar) {
        if (this.gaX == null) {
            this.gaX = new ArrayList();
        }
        this.gaX.add(aVar);
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
                this.gaQ.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.b().showToast(d.f.icon_toast_game_error, d.k.form_commit_error_string);
            this.gaQ.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjT() {
        this.gaQ.setVisibility(4);
        this.gaS.setVisibility(4);
        this.gaR.setVisibility(0);
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
            this.gaQ.setClickable(true);
        } else {
            b.bjm().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.Sd) {
                            FormCardView.this.gaW.setCommitState(true);
                            FormCardView.this.bjT();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.b().j(hVar.errorString);
                            FormCardView.this.gaW.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.b().showToast(d.f.icon_toast_game_error, d.k.form_commit_fail_string);
                            FormCardView.this.gaW.setCommitState(false);
                        }
                    }
                    FormCardView.this.gaQ.setClickable(true);
                }
            });
        }
    }
}
