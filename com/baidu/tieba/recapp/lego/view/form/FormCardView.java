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
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.R;
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
/* loaded from: classes25.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String aQL;
    private TitleView lPm;
    private CommitView lPn;
    private LinearLayout lPo;
    private LinearLayout lPp;
    private ImageView lPq;
    private TextView lPr;
    private TextView lPs;
    private FormCard lPt;
    private List<a> lPu;
    private float lPv;
    private int lPw;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes25.dex */
    public interface a {
        boolean dru();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aQL = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.lPv = 1.0f;
        this.lPw = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cPW() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.lPm = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.lPq = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.lPq.setEnabled(false);
        this.lPn = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.lPp = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.lPo = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.lPr = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.lPs = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.lPn != null) {
            this.lPn.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.lPu, FormCardView.this.lPn.getPostUrl(), FormCardView.this.aQL);
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
    public void d(FormCard formCard) {
        if (formCard != null && formCard.mIsLegal && this.lPt != formCard) {
            drB();
            this.lPt = formCard;
            this.aQL = formCard.getItemId();
            dg(formCard.mWidth, formCard.mHeight);
            this.lPm.aC(this.lPv);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lPm.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.lPv);
            }
            this.lPn.aC(this.lPv);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lPn.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.lPv);
            }
            this.lPm.a(formCard.titleInfo);
            this.lPn.a(formCard.commitInfo);
            b.dqV().a(new com.baidu.tieba.recapp.a.a(this.lPn.getPostUrl()));
            dry();
            drA();
            drz();
            a(this.lPm);
            a(this.lPn);
            if (formCard.isCommitSuccess()) {
                drC();
            }
            if (!formCard.mHasShown) {
                r.dqU().dqQ().dQ(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void dg(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.lPv = (float) (this.mScreenWidth / 750.0d);
    }

    private void dry() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.lPt.backgroundInfo != null) {
            this.lPq.setVisibility(0);
            if (!TextUtils.isEmpty(this.lPt.backgroundInfo.img)) {
                c.mR().a(this.lPt.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.getRawBitmap() != null) {
                                    int height = aVar.getRawBitmap().getHeight();
                                    int width = aVar.getRawBitmap().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.lPt.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.lPq.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.lPq.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.lPq.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.lPq.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int fq = com.baidu.tieba.lego.card.d.b.fq(FormCardView.this.lPt.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.b.CO(fq)) {
                                            FormCardView.this.mRootView.setBackgroundColor(fq);
                                        }
                                        aVar.drawImageTo(FormCardView.this.lPq);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.lPq.setImageBitmap(null);
                                FormCardView.this.lPq.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.lPq.setImageBitmap(null);
                                FormCardView.this.lPq.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.lPq.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.lPq.setVisibility(8);
    }

    private void drz() {
        FormCard.f fVar = this.lPt.resultInfo;
        float dimension = this.ehG.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.ehG.getResources().getDimension(R.dimen.fontsize28);
        int color = this.ehG.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.lPr.setText(fVar.title);
            this.lPr.setTextColor(-1);
            this.lPr.setTextSize(0, dimension);
            this.lPs.setText(fVar.desc);
            this.lPs.setTextColor(color);
            this.lPs.setTextSize(0, dimension2);
        }
    }

    private void drA() {
        if (this.lPt.itemList != null && this.lPt.itemList.size() > 0) {
            int size = this.lPt.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.lPt.itemList.get(i);
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

    private void drB() {
        this.lPp.removeAllViews();
        if (this.lPu != null) {
            com.baidu.tieba.lego.card.d.a.clear(this.lPu);
        } else {
            this.lPu = new ArrayList();
        }
        this.lPn.setVisibility(0);
        this.lPp.setVisibility(0);
        this.lPo.setVisibility(8);
        this.lPn.setClickable(true);
        this.lPq.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aC(this.lPv);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.lPp.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.drD());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.lPv);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.drD()));
        }
    }

    public void a(a aVar) {
        if (this.lPu == null) {
            this.lPu = new ArrayList();
        }
        com.baidu.tieba.lego.card.d.a.a(this.lPu, aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject fR;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.dru()) {
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
                    if (formView2 != null && (fR = fR(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(fR);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.lPn.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.lPn.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drC() {
        this.lPn.setVisibility(4);
        this.lPp.setVisibility(4);
        this.lPo.setVisibility(0);
    }

    private JSONObject fR(String str, String str2) {
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

    private void e(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.lPn.setClickable(true);
        } else {
            b.dqV().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.lPt.setCommitState(true);
                            FormCardView.this.drC();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.lPt.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.lPt.setCommitState(false);
                        }
                    }
                    FormCardView.this.lPn.setClickable(true);
                }
            });
        }
    }
}
