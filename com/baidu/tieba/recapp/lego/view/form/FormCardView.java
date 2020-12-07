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
    private String aXU;
    private Activity mActivity;
    private CommitView mLA;
    private LinearLayout mLB;
    private LinearLayout mLC;
    private ImageView mLD;
    private TextView mLE;
    private TextView mLF;
    private FormCard mLG;
    private List<a> mLH;
    private float mLI;
    private int mLJ;
    private TitleView mLz;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes26.dex */
    public interface a {
        boolean dFC();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aXU = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.mLI = 1.0f;
        this.mLJ = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddV() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.mLz = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.mLD = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.mLD.setEnabled(false);
        this.mLA = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.mLC = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.mLB = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.mLE = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.mLF = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.mLA != null) {
            this.mLA.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.mLH, FormCardView.this.mLA.getPostUrl(), FormCardView.this.aXU);
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
        if (formCard != null && formCard.mIsLegal && this.mLG != formCard) {
            dFJ();
            this.mLG = formCard;
            this.aXU = formCard.getItemId();
            dp(formCard.mWidth, formCard.mHeight);
            this.mLz.aU(this.mLI);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mLz.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mLI);
            }
            this.mLA.aU(this.mLI);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mLA.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mLI);
            }
            this.mLz.a(formCard.titleInfo);
            this.mLA.a(formCard.commitInfo);
            b.dFg().a(new com.baidu.tieba.recapp.a.a(this.mLA.getPostUrl()));
            dFG();
            dFI();
            dFH();
            a(this.mLz);
            a(this.mLA);
            if (formCard.isCommitSuccess()) {
                dFK();
            }
            if (!formCard.mHasShown) {
                r.dFf().dFb().el(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void dp(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.mLI = (float) (this.mScreenWidth / 750.0d);
    }

    private void dFG() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.mLG.backgroundInfo != null) {
            this.mLD.setVisibility(0);
            if (!TextUtils.isEmpty(this.mLG.backgroundInfo.img)) {
                c.mS().a(this.mLG.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.mLG.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.mLD.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mLD.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.mLD.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mLD.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int sI = com.baidu.tieba.lego.card.d.b.sI(FormCardView.this.mLG.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.b.Fn(sI)) {
                                            FormCardView.this.mRootView.setBackgroundColor(sI);
                                        }
                                        aVar.drawImageTo(FormCardView.this.mLD);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.mLD.setImageBitmap(null);
                                FormCardView.this.mLD.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.mLD.setImageBitmap(null);
                                FormCardView.this.mLD.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.mLD.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.mLD.setVisibility(8);
    }

    private void dFH() {
        FormCard.f fVar = this.mLG.resultInfo;
        float dimension = this.eNx.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.eNx.getResources().getDimension(R.dimen.fontsize28);
        int color = this.eNx.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.mLE.setText(fVar.title);
            this.mLE.setTextColor(-1);
            this.mLE.setTextSize(0, dimension);
            this.mLF.setText(fVar.desc);
            this.mLF.setTextColor(color);
            this.mLF.setTextSize(0, dimension2);
        }
    }

    private void dFI() {
        if (this.mLG.itemList != null && this.mLG.itemList.size() > 0) {
            int size = this.mLG.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.mLG.itemList.get(i);
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

    private void dFJ() {
        this.mLC.removeAllViews();
        if (this.mLH != null) {
            com.baidu.tieba.lego.card.d.a.clear(this.mLH);
        } else {
            this.mLH = new ArrayList();
        }
        this.mLA.setVisibility(0);
        this.mLC.setVisibility(0);
        this.mLB.setVisibility(8);
        this.mLA.setClickable(true);
        this.mLD.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aU(this.mLI);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.mLC.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.dFL());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.mLI);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.dFL()));
        }
    }

    public void a(a aVar) {
        if (this.mLH == null) {
            this.mLH = new ArrayList();
        }
        com.baidu.tieba.lego.card.d.a.a(this.mLH, aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject gi;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.dFC()) {
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
                    if (formView2 != null && (gi = gi(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(gi);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.mLA.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.mLA.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFK() {
        this.mLA.setVisibility(4);
        this.mLC.setVisibility(4);
        this.mLB.setVisibility(0);
    }

    private JSONObject gi(String str, String str2) {
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
            this.mLA.setClickable(true);
        } else {
            b.dFg().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.mLG.setCommitState(true);
                            FormCardView.this.dFK();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.mLG.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.mLG.setCommitState(false);
                        }
                    }
                    FormCardView.this.mLA.setClickable(true);
                }
            });
        }
    }
}
