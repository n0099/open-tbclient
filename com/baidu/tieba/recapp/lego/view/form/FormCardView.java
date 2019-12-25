package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.view.d;
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
/* loaded from: classes10.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String akT;
    private TitleView jFH;
    private CommitView jFI;
    private LinearLayout jFJ;
    private LinearLayout jFK;
    private ImageView jFL;
    private TextView jFM;
    private TextView jFN;
    private FormCard jFO;
    private List<a> jFP;
    private float jFQ;
    private int jFR;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes10.dex */
    public interface a {
        boolean cAq();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.akT = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.jFQ = 1.0f;
        this.jFR = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bZt() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.jFH = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.jFL = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.jFL.setEnabled(false);
        this.jFI = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.jFK = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.jFJ = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.jFM = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.jFN = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.jFI != null) {
            this.jFI.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.jFP, FormCardView.this.jFI.getPostUrl(), FormCardView.this.akT);
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
        if (formCard != null && formCard.mIsLegal && this.jFO != formCard) {
            cAx();
            this.jFO = formCard;
            this.akT = formCard.getItemId();
            cB(formCard.mWidth, formCard.mHeight);
            this.jFH.aL(this.jFQ);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jFH.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.jFQ);
            }
            this.jFI.aL(this.jFQ);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.jFI.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.jFQ);
            }
            this.jFH.a(formCard.titleInfo);
            this.jFI.a(formCard.commitInfo);
            b.czP().a(new com.baidu.tieba.recapp.a.a(this.jFI.getPostUrl()));
            cAu();
            cAw();
            cAv();
            a(this.jFH);
            a(this.jFI);
            if (formCard.isCommitSuccess()) {
                cAy();
            }
            if (!formCard.mHasShown) {
                r.czO().czK().cB(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cB(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.jFQ = (float) (this.mScreenWidth / 750.0d);
    }

    private void cAu() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.jFO.backgroundInfo != null) {
            this.jFL.setVisibility(0);
            if (!TextUtils.isEmpty(this.jFO.backgroundInfo.img)) {
                c.gs().a(this.jFO.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.jFO.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.jFL.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.jFL.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.jFL.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.jFL.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int cy = com.baidu.tieba.lego.card.d.a.cy(FormCardView.this.jFO.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.xg(cy)) {
                                            FormCardView.this.mRootView.setBackgroundColor(cy);
                                        }
                                        aVar.drawImageTo(FormCardView.this.jFL);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.jFL.setImageBitmap(null);
                                FormCardView.this.jFL.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.jFL.setImageBitmap(null);
                                FormCardView.this.jFL.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.jFL.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.jFL.setVisibility(8);
    }

    private void cAv() {
        FormCard.f fVar = this.jFO.resultInfo;
        float dimension = this.cQU.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.cQU.getResources().getDimension(R.dimen.fontsize28);
        int color = this.cQU.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.jFM.setText(fVar.title);
            this.jFM.setTextColor(-1);
            this.jFM.setTextSize(0, dimension);
            this.jFN.setText(fVar.desc);
            this.jFN.setTextColor(color);
            this.jFN.setTextSize(0, dimension2);
        }
    }

    private void cAw() {
        if (this.jFO.itemList != null && this.jFO.itemList.size() > 0) {
            int size = this.jFO.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.jFO.itemList.get(i);
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

    private void cAx() {
        this.jFK.removeAllViews();
        if (this.jFP != null) {
            this.jFP.clear();
        } else {
            this.jFP = new ArrayList();
        }
        this.jFI.setVisibility(0);
        this.jFK.setVisibility(0);
        this.jFJ.setVisibility(8);
        this.jFI.setClickable(true);
        this.jFL.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aL(this.jFQ);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.jFK.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.cAz());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.jFQ);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.cAz()));
        }
    }

    public void a(a aVar) {
        if (this.jFP == null) {
            this.jFP = new ArrayList();
        }
        this.jFP.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject ef;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.cAq()) {
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
                    if (formView2 != null && (ef = ef(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(ef);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.jFI.setClickable(false);
                return;
            }
            new d().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.jFI.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAy() {
        this.jFI.setVisibility(4);
        this.jFK.setVisibility(4);
        this.jFJ.setVisibility(0);
    }

    private JSONObject ef(String str, String str2) {
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
            this.jFI.setClickable(true);
        } else {
            b.czP().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.jFO.setCommitState(true);
                            FormCardView.this.cAy();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new d().showFailToast(hVar.errorString);
                            FormCardView.this.jFO.setCommitState(false);
                        } else {
                            new d().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.jFO.setCommitState(false);
                        }
                    }
                    FormCardView.this.jFI.setClickable(true);
                }
            });
        }
    }
}
