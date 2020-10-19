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
/* loaded from: classes26.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String aTW;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;
    private TitleView meE;
    private CommitView meF;
    private LinearLayout meG;
    private LinearLayout meH;
    private ImageView meI;
    private TextView meJ;
    private TextView meK;
    private FormCard meL;
    private List<a> meM;
    private float meN;
    private int meO;

    /* loaded from: classes26.dex */
    public interface a {
        boolean dvf();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aTW = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.meN = 1.0f;
        this.meO = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cTG() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.meE = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.meI = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.meI.setEnabled(false);
        this.meF = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.meH = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.meG = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.meJ = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.meK = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.meF != null) {
            this.meF.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.meM, FormCardView.this.meF.getPostUrl(), FormCardView.this.aTW);
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
        if (formCard != null && formCard.mIsLegal && this.meL != formCard) {
            dvm();
            this.meL = formCard;
            this.aTW = formCard.getItemId();
            dg(formCard.mWidth, formCard.mHeight);
            this.meE.aI(this.meN);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.meE.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.meN);
            }
            this.meF.aI(this.meN);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.meF.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.meN);
            }
            this.meE.a(formCard.titleInfo);
            this.meF.a(formCard.commitInfo);
            b.duG().a(new com.baidu.tieba.recapp.a.a(this.meF.getPostUrl()));
            dvj();
            dvl();
            dvk();
            a(this.meE);
            a(this.meF);
            if (formCard.isCommitSuccess()) {
                dvn();
            }
            if (!formCard.mHasShown) {
                r.duF().duB().dW(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void dg(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.meN = (float) (this.mScreenWidth / 750.0d);
    }

    private void dvj() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.meL.backgroundInfo != null) {
            this.meI.setVisibility(0);
            if (!TextUtils.isEmpty(this.meL.backgroundInfo.img)) {
                c.mS().a(this.meL.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.meL.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.meI.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.meI.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.meI.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.meI.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int fv = com.baidu.tieba.lego.card.d.b.fv(FormCardView.this.meL.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.b.Du(fv)) {
                                            FormCardView.this.mRootView.setBackgroundColor(fv);
                                        }
                                        aVar.drawImageTo(FormCardView.this.meI);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.meI.setImageBitmap(null);
                                FormCardView.this.meI.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.meI.setImageBitmap(null);
                                FormCardView.this.meI.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.meI.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.meI.setVisibility(8);
    }

    private void dvk() {
        FormCard.f fVar = this.meL.resultInfo;
        float dimension = this.etO.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.etO.getResources().getDimension(R.dimen.fontsize28);
        int color = this.etO.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.meJ.setText(fVar.title);
            this.meJ.setTextColor(-1);
            this.meJ.setTextSize(0, dimension);
            this.meK.setText(fVar.desc);
            this.meK.setTextColor(color);
            this.meK.setTextSize(0, dimension2);
        }
    }

    private void dvl() {
        if (this.meL.itemList != null && this.meL.itemList.size() > 0) {
            int size = this.meL.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.meL.itemList.get(i);
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

    private void dvm() {
        this.meH.removeAllViews();
        if (this.meM != null) {
            com.baidu.tieba.lego.card.d.a.clear(this.meM);
        } else {
            this.meM = new ArrayList();
        }
        this.meF.setVisibility(0);
        this.meH.setVisibility(0);
        this.meG.setVisibility(8);
        this.meF.setClickable(true);
        this.meI.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aI(this.meN);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.meH.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.dvo());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.meN);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.dvo()));
        }
    }

    public void a(a aVar) {
        if (this.meM == null) {
            this.meM = new ArrayList();
        }
        com.baidu.tieba.lego.card.d.a.a(this.meM, aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject fY;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.dvf()) {
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
                    if (formView2 != null && (fY = fY(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(fY);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.meF.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.meF.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvn() {
        this.meF.setVisibility(4);
        this.meH.setVisibility(4);
        this.meG.setVisibility(0);
    }

    private JSONObject fY(String str, String str2) {
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
            this.meF.setClickable(true);
        } else {
            b.duG().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.meL.setCommitState(true);
                            FormCardView.this.dvn();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.meL.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.meL.setCommitState(false);
                        }
                    }
                    FormCardView.this.meF.setClickable(true);
                }
            });
        }
    }
}
