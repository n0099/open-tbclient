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
    private TitleView mLB;
    private CommitView mLC;
    private LinearLayout mLD;
    private LinearLayout mLE;
    private ImageView mLF;
    private TextView mLG;
    private TextView mLH;
    private FormCard mLI;
    private List<a> mLJ;
    private float mLK;
    private int mLL;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes26.dex */
    public interface a {
        boolean dFD();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aXU = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.mLK = 1.0f;
        this.mLL = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddW() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.mLB = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.mLF = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.mLF.setEnabled(false);
        this.mLC = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.mLE = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.mLD = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.mLG = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.mLH = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.mLC != null) {
            this.mLC.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.mLJ, FormCardView.this.mLC.getPostUrl(), FormCardView.this.aXU);
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
        if (formCard != null && formCard.mIsLegal && this.mLI != formCard) {
            dFK();
            this.mLI = formCard;
            this.aXU = formCard.getItemId();
            dp(formCard.mWidth, formCard.mHeight);
            this.mLB.aU(this.mLK);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mLB.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mLK);
            }
            this.mLC.aU(this.mLK);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mLC.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mLK);
            }
            this.mLB.a(formCard.titleInfo);
            this.mLC.a(formCard.commitInfo);
            b.dFh().a(new com.baidu.tieba.recapp.a.a(this.mLC.getPostUrl()));
            dFH();
            dFJ();
            dFI();
            a(this.mLB);
            a(this.mLC);
            if (formCard.isCommitSuccess()) {
                dFL();
            }
            if (!formCard.mHasShown) {
                r.dFg().dFc().el(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void dp(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.mLK = (float) (this.mScreenWidth / 750.0d);
    }

    private void dFH() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.mLI.backgroundInfo != null) {
            this.mLF.setVisibility(0);
            if (!TextUtils.isEmpty(this.mLI.backgroundInfo.img)) {
                c.mS().a(this.mLI.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.mLI.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.mLF.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mLF.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.mLF.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mLF.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int sI = com.baidu.tieba.lego.card.d.b.sI(FormCardView.this.mLI.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.b.Fn(sI)) {
                                            FormCardView.this.mRootView.setBackgroundColor(sI);
                                        }
                                        aVar.drawImageTo(FormCardView.this.mLF);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.mLF.setImageBitmap(null);
                                FormCardView.this.mLF.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.mLF.setImageBitmap(null);
                                FormCardView.this.mLF.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.mLF.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.mLF.setVisibility(8);
    }

    private void dFI() {
        FormCard.f fVar = this.mLI.resultInfo;
        float dimension = this.eNx.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.eNx.getResources().getDimension(R.dimen.fontsize28);
        int color = this.eNx.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.mLG.setText(fVar.title);
            this.mLG.setTextColor(-1);
            this.mLG.setTextSize(0, dimension);
            this.mLH.setText(fVar.desc);
            this.mLH.setTextColor(color);
            this.mLH.setTextSize(0, dimension2);
        }
    }

    private void dFJ() {
        if (this.mLI.itemList != null && this.mLI.itemList.size() > 0) {
            int size = this.mLI.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.mLI.itemList.get(i);
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

    private void dFK() {
        this.mLE.removeAllViews();
        if (this.mLJ != null) {
            com.baidu.tieba.lego.card.d.a.clear(this.mLJ);
        } else {
            this.mLJ = new ArrayList();
        }
        this.mLC.setVisibility(0);
        this.mLE.setVisibility(0);
        this.mLD.setVisibility(8);
        this.mLC.setClickable(true);
        this.mLF.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aU(this.mLK);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.mLE.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.dFM());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.mLK);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.dFM()));
        }
    }

    public void a(a aVar) {
        if (this.mLJ == null) {
            this.mLJ = new ArrayList();
        }
        com.baidu.tieba.lego.card.d.a.a(this.mLJ, aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject gi;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.dFD()) {
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
                this.mLC.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.mLC.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFL() {
        this.mLC.setVisibility(4);
        this.mLE.setVisibility(4);
        this.mLD.setVisibility(0);
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
            this.mLC.setClickable(true);
        } else {
            b.dFh().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.mLI.setCommitState(true);
                            FormCardView.this.dFL();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.mLI.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.mLI.setCommitState(false);
                        }
                    }
                    FormCardView.this.mLC.setClickable(true);
                }
            });
        }
    }
}
