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
    private TitleView lpI;
    private CommitView lpJ;
    private LinearLayout lpK;
    private LinearLayout lpL;
    private ImageView lpM;
    private TextView lpN;
    private TextView lpO;
    private FormCard lpP;
    private List<a> lpQ;
    private float lpR;
    private int lpS;
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
        this.lpR = 1.0f;
        this.lpS = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cBx() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.lpI = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.lpM = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.lpM.setEnabled(false);
        this.lpJ = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.lpL = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.lpK = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.lpN = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.lpO = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.lpJ != null) {
            this.lpJ.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.lpQ, FormCardView.this.lpJ.getPostUrl(), FormCardView.this.aJw);
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
        if (formCard != null && formCard.mIsLegal && this.lpP != formCard) {
            dcG();
            this.lpP = formCard;
            this.aJw = formCard.getItemId();
            cV(formCard.mWidth, formCard.mHeight);
            this.lpI.aw(this.lpR);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lpI.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.lpR);
            }
            this.lpJ.aw(this.lpR);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lpJ.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.lpR);
            }
            this.lpI.a(formCard.titleInfo);
            this.lpJ.a(formCard.commitInfo);
            b.dcb().a(new com.baidu.tieba.recapp.a.a(this.lpJ.getPostUrl()));
            dcD();
            dcF();
            dcE();
            a(this.lpI);
            a(this.lpJ);
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
        this.lpR = (float) (this.mScreenWidth / 750.0d);
    }

    private void dcD() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.lpP.backgroundInfo != null) {
            this.lpM.setVisibility(0);
            if (!TextUtils.isEmpty(this.lpP.backgroundInfo.img)) {
                c.ln().a(this.lpP.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.lpP.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.lpM.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.lpM.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.lpM.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.lpM.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int dU = com.baidu.tieba.lego.card.d.a.dU(FormCardView.this.lpP.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.zU(dU)) {
                                            FormCardView.this.mRootView.setBackgroundColor(dU);
                                        }
                                        aVar.drawImageTo(FormCardView.this.lpM);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.lpM.setImageBitmap(null);
                                FormCardView.this.lpM.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.lpM.setImageBitmap(null);
                                FormCardView.this.lpM.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.lpM.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.lpM.setVisibility(8);
    }

    private void dcE() {
        FormCard.f fVar = this.lpP.resultInfo;
        float dimension = this.dVN.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.dVN.getResources().getDimension(R.dimen.fontsize28);
        int color = this.dVN.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.lpN.setText(fVar.title);
            this.lpN.setTextColor(-1);
            this.lpN.setTextSize(0, dimension);
            this.lpO.setText(fVar.desc);
            this.lpO.setTextColor(color);
            this.lpO.setTextSize(0, dimension2);
        }
    }

    private void dcF() {
        if (this.lpP.itemList != null && this.lpP.itemList.size() > 0) {
            int size = this.lpP.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.lpP.itemList.get(i);
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
        this.lpL.removeAllViews();
        if (this.lpQ != null) {
            this.lpQ.clear();
        } else {
            this.lpQ = new ArrayList();
        }
        this.lpJ.setVisibility(0);
        this.lpL.setVisibility(0);
        this.lpK.setVisibility(8);
        this.lpJ.setClickable(true);
        this.lpM.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aw(this.lpR);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.lpL.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.dcI());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.lpR);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.dcI()));
        }
    }

    public void a(a aVar) {
        if (this.lpQ == null) {
            this.lpQ = new ArrayList();
        }
        this.lpQ.add(aVar);
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
                this.lpJ.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.lpJ.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcH() {
        this.lpJ.setVisibility(4);
        this.lpL.setVisibility(4);
        this.lpK.setVisibility(0);
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
            this.lpJ.setClickable(true);
        } else {
            b.dcb().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.lpP.setCommitState(true);
                            FormCardView.this.dcH();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.lpP.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.lpP.setCommitState(false);
                        }
                    }
                    FormCardView.this.lpJ.setClickable(true);
                }
            });
        }
    }
}
