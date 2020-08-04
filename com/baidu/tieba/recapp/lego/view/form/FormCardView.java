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
/* loaded from: classes20.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String aJw;
    private TitleView lpK;
    private CommitView lpL;
    private LinearLayout lpM;
    private LinearLayout lpN;
    private ImageView lpO;
    private TextView lpP;
    private TextView lpQ;
    private FormCard lpR;
    private List<a> lpS;
    private float lpT;
    private int lpU;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes20.dex */
    public interface a {
        boolean dcz();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aJw = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.lpT = 1.0f;
        this.lpU = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cBx() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.lpK = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.lpO = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.lpO.setEnabled(false);
        this.lpL = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.lpN = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.lpM = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.lpP = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.lpQ = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.lpL != null) {
            this.lpL.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.lpS, FormCardView.this.lpL.getPostUrl(), FormCardView.this.aJw);
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
        if (formCard != null && formCard.mIsLegal && this.lpR != formCard) {
            dcG();
            this.lpR = formCard;
            this.aJw = formCard.getItemId();
            cV(formCard.mWidth, formCard.mHeight);
            this.lpK.aw(this.lpT);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lpK.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.lpT);
            }
            this.lpL.aw(this.lpT);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lpL.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.lpT);
            }
            this.lpK.a(formCard.titleInfo);
            this.lpL.a(formCard.commitInfo);
            b.dcb().a(new com.baidu.tieba.recapp.a.a(this.lpL.getPostUrl()));
            dcD();
            dcF();
            dcE();
            a(this.lpK);
            a(this.lpL);
            if (formCard.isCommitSuccess()) {
                dcH();
            }
            if (!formCard.mHasShown) {
                r.dca().dbW().dx(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cV(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.lpT = (float) (this.mScreenWidth / 750.0d);
    }

    private void dcD() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.lpR.backgroundInfo != null) {
            this.lpO.setVisibility(0);
            if (!TextUtils.isEmpty(this.lpR.backgroundInfo.img)) {
                c.ln().a(this.lpR.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.lpR.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.lpO.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.lpO.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.lpO.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.lpO.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int dU = com.baidu.tieba.lego.card.d.a.dU(FormCardView.this.lpR.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.zU(dU)) {
                                            FormCardView.this.mRootView.setBackgroundColor(dU);
                                        }
                                        aVar.drawImageTo(FormCardView.this.lpO);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.lpO.setImageBitmap(null);
                                FormCardView.this.lpO.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.lpO.setImageBitmap(null);
                                FormCardView.this.lpO.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.lpO.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.lpO.setVisibility(8);
    }

    private void dcE() {
        FormCard.f fVar = this.lpR.resultInfo;
        float dimension = this.dVN.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.dVN.getResources().getDimension(R.dimen.fontsize28);
        int color = this.dVN.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.lpP.setText(fVar.title);
            this.lpP.setTextColor(-1);
            this.lpP.setTextSize(0, dimension);
            this.lpQ.setText(fVar.desc);
            this.lpQ.setTextColor(color);
            this.lpQ.setTextSize(0, dimension2);
        }
    }

    private void dcF() {
        if (this.lpR.itemList != null && this.lpR.itemList.size() > 0) {
            int size = this.lpR.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.lpR.itemList.get(i);
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

    private void dcG() {
        this.lpN.removeAllViews();
        if (this.lpS != null) {
            this.lpS.clear();
        } else {
            this.lpS = new ArrayList();
        }
        this.lpL.setVisibility(0);
        this.lpN.setVisibility(0);
        this.lpM.setVisibility(8);
        this.lpL.setClickable(true);
        this.lpO.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aw(this.lpT);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.lpN.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.dcI());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.lpT);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.dcI()));
        }
    }

    public void a(a aVar) {
        if (this.lpS == null) {
            this.lpS = new ArrayList();
        }
        this.lpS.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject fn;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.dcz()) {
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
                    if (formView2 != null && (fn = fn(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(fn);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.lpL.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.lpL.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcH() {
        this.lpL.setVisibility(4);
        this.lpN.setVisibility(4);
        this.lpM.setVisibility(0);
    }

    private JSONObject fn(String str, String str2) {
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
            this.lpL.setClickable(true);
        } else {
            b.dcb().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.lpR.setCommitState(true);
                            FormCardView.this.dcH();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.lpR.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.lpR.setCommitState(false);
                        }
                    }
                    FormCardView.this.lpL.setClickable(true);
                }
            });
        }
    }
}
