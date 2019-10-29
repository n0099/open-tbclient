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
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.view.e;
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
/* loaded from: classes3.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String adp;
    private TitleView iMj;
    private CommitView iMk;
    private LinearLayout iMl;
    private LinearLayout iMm;
    private ImageView iMn;
    private TextView iMo;
    private TextView iMp;
    private FormCard iMq;
    private List<a> iMr;
    private float iMs;
    private int iMt;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean cgo();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.adp = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.iMs = 1.0f;
        this.iMt = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bIg() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.iMj = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.iMn = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.iMn.setEnabled(false);
        this.iMk = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.iMm = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.iMl = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.iMo = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.iMp = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.iMk != null) {
            this.iMk.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.iMr, FormCardView.this.iMk.getPostUrl(), FormCardView.this.adp);
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
        if (formCard != null && formCard.mIsLegal && this.iMq != formCard) {
            cgv();
            this.iMq = formCard;
            this.adp = formCard.getItemId();
            cj(formCard.mWidth, formCard.mHeight);
            this.iMj.au(this.iMs);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iMj.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iMs);
            }
            this.iMk.au(this.iMs);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iMk.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iMs);
            }
            this.iMj.a(formCard.titleInfo);
            this.iMk.a(formCard.commitInfo);
            b.cfM().a(new com.baidu.tieba.recapp.a.a(this.iMk.getPostUrl()));
            cgs();
            cgu();
            cgt();
            a(this.iMj);
            a(this.iMk);
            if (formCard.isCommitSuccess()) {
                cgw();
            }
            if (!formCard.mHasShown) {
                r.cfL().cfH().ce(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cj(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.iMs = (float) (this.mScreenWidth / 750.0d);
    }

    private void cgs() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.iMq.backgroundInfo != null) {
            this.iMn.setVisibility(0);
            if (!TextUtils.isEmpty(this.iMq.backgroundInfo.img)) {
                c.fT().a(this.iMq.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.getRawBitmap() != null) {
                                    int height = aVar.getRawBitmap().getHeight();
                                    int width = aVar.getRawBitmap().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.iMq.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.iMn.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iMn.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.iMn.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iMn.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int bR = com.baidu.tieba.lego.card.d.a.bR(FormCardView.this.iMq.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.vf(bR)) {
                                            FormCardView.this.mRootView.setBackgroundColor(bR);
                                        }
                                        aVar.drawImageTo(FormCardView.this.iMn);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.iMn.setImageBitmap(null);
                                FormCardView.this.iMn.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.iMn.setImageBitmap(null);
                                FormCardView.this.iMn.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.iMn.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.iMn.setVisibility(8);
    }

    private void cgt() {
        FormCard.f fVar = this.iMq.resultInfo;
        float dimension = this.cfl.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.cfl.getResources().getDimension(R.dimen.fontsize28);
        int color = this.cfl.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.iMo.setText(fVar.title);
            this.iMo.setTextColor(-1);
            this.iMo.setTextSize(0, dimension);
            this.iMp.setText(fVar.desc);
            this.iMp.setTextColor(color);
            this.iMp.setTextSize(0, dimension2);
        }
    }

    private void cgu() {
        if (this.iMq.itemList != null && this.iMq.itemList.size() > 0) {
            int size = this.iMq.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.iMq.itemList.get(i);
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

    private void cgv() {
        this.iMm.removeAllViews();
        if (this.iMr != null) {
            this.iMr.clear();
        } else {
            this.iMr = new ArrayList();
        }
        this.iMk.setVisibility(0);
        this.iMm.setVisibility(0);
        this.iMl.setVisibility(8);
        this.iMk.setClickable(true);
        this.iMn.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.au(this.iMs);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.iMm.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.cgx());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.iMs);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.cgx()));
        }
    }

    public void a(a aVar) {
        if (this.iMr == null) {
            this.iMr = new ArrayList();
        }
        this.iMr.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject dM;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.cgo()) {
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
                    if (formView2 != null && (dM = dM(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(dM);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.iMk.setClickable(false);
                return;
            }
            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.iMk.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgw() {
        this.iMk.setVisibility(4);
        this.iMm.setVisibility(4);
        this.iMl.setVisibility(0);
    }

    private JSONObject dM(String str, String str2) {
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
            this.iMk.setClickable(true);
        } else {
            b.cfM().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.iMq.setCommitState(true);
                            FormCardView.this.cgw();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new e().showFailToast(hVar.errorString);
                            FormCardView.this.iMq.setCommitState(false);
                        } else {
                            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.iMq.setCommitState(false);
                        }
                    }
                    FormCardView.this.iMk.setClickable(true);
                }
            });
        }
    }
}
