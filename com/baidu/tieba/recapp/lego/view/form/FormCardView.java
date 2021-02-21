package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
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
import com.baidu.tieba.recapp.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String aXU;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;
    private TitleView mVS;
    private CommitView mVT;
    private LinearLayout mVU;
    private LinearLayout mVV;
    private ImageView mVW;
    private TextView mVX;
    private TextView mVY;
    private FormCard mVZ;
    private List<a> mWa;
    private float mWb;
    private int mWc;

    /* loaded from: classes8.dex */
    public interface a {
        boolean dDR();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aXU = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.mWb = 1.0f;
        this.mWc = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbV() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.mVS = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.mVW = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.mVW.setEnabled(false);
        this.mVT = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.mVV = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.mVU = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.mVX = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.mVY = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.mVT != null) {
            this.mVT.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.mWa, FormCardView.this.mVT.getPostUrl(), FormCardView.this.aXU);
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
        if (formCard != null && formCard.mIsLegal && this.mVZ != formCard) {
            dDY();
            this.mVZ = formCard;
            this.aXU = formCard.getItemId();
            dj(formCard.mWidth, formCard.mHeight);
            this.mVS.aZ(this.mWb);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mVS.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mWb);
            }
            this.mVT.aZ(this.mWb);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mVT.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mWb);
            }
            this.mVS.a(formCard.titleInfo);
            this.mVT.a(formCard.commitInfo);
            b.dDv().a(new com.baidu.tieba.recapp.a.a(this.mVT.getPostUrl()));
            dDV();
            dDX();
            dDW();
            a(this.mVS);
            a(this.mVT);
            if (formCard.isCommitSuccess()) {
                dDZ();
            }
            if (!formCard.mHasShown) {
                s.dDt().dDp().eh(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void dj(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.mWb = (float) (this.mScreenWidth / 750.0d);
    }

    private void dDV() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.mVZ.backgroundInfo != null) {
            this.mVW.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVZ.backgroundInfo.img)) {
                d.mw().a(this.mVZ.backgroundInfo.img, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.c
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.getRawBitmap() != null) {
                                    int height = aVar.getRawBitmap().getHeight();
                                    int width = aVar.getRawBitmap().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.mVZ.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.mVW.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mVW.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.mVW.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mVW.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int rM = com.baidu.tieba.lego.card.c.b.rM(FormCardView.this.mVZ.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.c.b.DT(rM)) {
                                            FormCardView.this.mRootView.setBackgroundColor(rM);
                                        }
                                        aVar.drawImageTo(FormCardView.this.mVW);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.mVW.setImageBitmap(null);
                                FormCardView.this.mVW.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.mVW.setImageBitmap(null);
                                FormCardView.this.mVW.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.mVW.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.mVW.setVisibility(8);
    }

    private void dDW() {
        FormCard.f fVar = this.mVZ.resultInfo;
        float dimension = this.eUY.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.eUY.getResources().getDimension(R.dimen.fontsize28);
        int color = this.eUY.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.mVX.setText(fVar.title);
            this.mVX.setTextColor(-1);
            this.mVX.setTextSize(0, dimension);
            this.mVY.setText(fVar.desc);
            this.mVY.setTextColor(color);
            this.mVY.setTextSize(0, dimension2);
        }
    }

    private void dDX() {
        if (this.mVZ.itemList != null && this.mVZ.itemList.size() > 0) {
            int size = this.mVZ.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.mVZ.itemList.get(i);
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

    private void dDY() {
        this.mVV.removeAllViews();
        if (this.mWa != null) {
            com.baidu.tieba.lego.card.c.a.clear(this.mWa);
        } else {
            this.mWa = new ArrayList();
        }
        this.mVT.setVisibility(0);
        this.mVV.setVisibility(0);
        this.mVU.setVisibility(8);
        this.mVT.setClickable(true);
        this.mVW.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aZ(this.mWb);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.mVV.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.dEa());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.mWb);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.dEa()));
        }
    }

    public void a(a aVar) {
        if (this.mWa == null) {
            this.mWa = new ArrayList();
        }
        com.baidu.tieba.lego.card.c.a.a(this.mWa, aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject gl;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.dDR()) {
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
                    if (formView2 != null && (gl = gl(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(gl);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                f(str, hashMap);
                this.mVT.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.mVT.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDZ() {
        this.mVT.setVisibility(4);
        this.mVV.setVisibility(4);
        this.mVU.setVisibility(0);
    }

    private JSONObject gl(String str, String str2) {
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

    private void f(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.mVT.setClickable(true);
        } else {
            b.dDv().a(null, str, hashMap, new e() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.mVZ.setCommitState(true);
                            FormCardView.this.dDZ();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.mVZ.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.mVZ.setCommitState(false);
                        }
                    }
                    FormCardView.this.mVT.setClickable(true);
                }
            });
        }
    }
}
