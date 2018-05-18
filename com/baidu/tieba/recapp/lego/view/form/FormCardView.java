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
    private int aSI;
    private TitleView gbS;
    private CommitView gbT;
    private LinearLayout gbU;
    private LinearLayout gbV;
    private ImageView gbW;
    private TextView gbX;
    private TextView gbY;
    private FormCard gbZ;
    private List<a> gca;
    private String gcb;
    private float gcc;
    private int gcd;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean bjK();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gcb = "";
        this.mScreenWidth = 0;
        this.aSI = 0;
        this.gcc = 1.0f;
        this.gcd = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aKT() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.i.card_form, (ViewGroup) null);
        this.gbS = (TitleView) this.mRootView.findViewById(d.g.form_title_view);
        this.gbW = (ImageView) this.mRootView.findViewById(d.g.tb_img_background);
        this.gbW.setEnabled(false);
        this.gbT = (CommitView) this.mRootView.findViewById(d.g.form_commit_view);
        this.gbV = (LinearLayout) this.mRootView.findViewById(d.g.item_content_view);
        this.gbU = (LinearLayout) this.mRootView.findViewById(d.g.form_commit_success_view);
        this.gbX = (TextView) this.mRootView.findViewById(d.g.form_success_title);
        this.gbY = (TextView) this.mRootView.findViewById(d.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gbT != null) {
            this.gbT.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    FormCardView.this.b(FormCardView.this.gca, FormCardView.this.gbT.getPostUrl(), FormCardView.this.gcb);
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
        if (formCard != null && formCard.mIsLegal && this.gbZ != formCard) {
            bjR();
            this.gbZ = formCard;
            this.gcb = formCard.getItemId();
            bz(formCard.mWidth, formCard.mHeight);
            this.gbS.ar(this.gcc);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gbS.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.gcc);
            }
            this.gbT.ar(this.gcc);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gbT.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.gcc);
            }
            this.gbS.a(formCard.titleInfo);
            this.gbT.a(formCard.commitInfo);
            b.bjl().a(new com.baidu.tieba.recapp.a.a(this.gbT.getPostUrl()));
            bjO();
            bjQ();
            bjP();
            a(this.gbS);
            a(this.gbT);
            if (formCard.isCommitSuccess()) {
                bjS();
            }
            if (!formCard.mHasShown) {
                r.bjk().bjg().aw(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void bz(int i, int i2) {
        this.aSI = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.aSI;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gcc = (float) (this.mScreenWidth / 750.0d);
    }

    private void bjO() {
        this.mRootView.setBackgroundResource(d.f.form_defalut_bg_image);
        if (this.gbZ.backgroundInfo != null) {
            this.gbW.setVisibility(0);
            if (!TextUtils.isEmpty(this.gbZ.backgroundInfo.img)) {
                c.fp().a(this.gbZ.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.kl() != null) {
                                    int height = aVar.kl().getHeight();
                                    int width = aVar.kl().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.gbZ.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.gbW.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gbW.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.gbW.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gbW.getLayoutParams().height = FormCardView.this.aSI;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.gbZ.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.ou(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.gbW);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.gbW.setImageBitmap(null);
                                FormCardView.this.gbW.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.gbW.setImageBitmap(null);
                                FormCardView.this.gbW.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.gbW.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gbW.setVisibility(8);
    }

    private void bjP() {
        FormCard.f fVar = this.gbZ.resultInfo;
        float dimension = this.mContext.getResources().getDimension(d.e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(d.e.fontsize28);
        int color = this.mContext.getResources().getColor(d.C0126d.form_font_color);
        if (fVar != null) {
            this.gbX.setText(fVar.title);
            this.gbX.setTextColor(-1);
            this.gbX.setTextSize(0, dimension);
            this.gbY.setText(fVar.desc);
            this.gbY.setTextColor(color);
            this.gbY.setTextSize(0, dimension2);
        }
    }

    private void bjQ() {
        if (this.gbZ.itemList != null && this.gbZ.itemList.size() > 0) {
            int size = this.gbZ.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gbZ.itemList.get(i);
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

    private void bjR() {
        this.gbV.removeAllViews();
        if (this.gca != null) {
            this.gca.clear();
        } else {
            this.gca = new ArrayList();
        }
        this.gbT.setVisibility(0);
        this.gbV.setVisibility(0);
        this.gbU.setVisibility(8);
        this.gbT.setClickable(true);
        this.gbW.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.ar(this.gcc);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gbV.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.bjT());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size40)) * this.gcc);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.bjT()));
        }
    }

    public void a(a aVar) {
        if (this.gca == null) {
            this.gca = new ArrayList();
        }
        this.gca.add(aVar);
    }

    public void b(List<a> list, String str, String str2) {
        JSONObject bQ;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.bjK()) {
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
                this.gbT.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.b().showToast(d.f.icon_toast_game_error, d.k.form_commit_error_string);
            this.gbT.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjS() {
        this.gbT.setVisibility(4);
        this.gbV.setVisibility(4);
        this.gbU.setVisibility(0);
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
            this.gbT.setClickable(true);
        } else {
            b.bjl().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.RZ) {
                            FormCardView.this.gbZ.setCommitState(true);
                            FormCardView.this.bjS();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.b().j(hVar.errorString);
                            FormCardView.this.gbZ.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.b().showToast(d.f.icon_toast_game_error, d.k.form_commit_fail_string);
                            FormCardView.this.gbZ.setCommitState(false);
                        }
                    }
                    FormCardView.this.gbT.setClickable(true);
                }
            });
        }
    }
}
