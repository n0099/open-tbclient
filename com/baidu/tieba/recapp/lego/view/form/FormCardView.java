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
    private String acW;
    private List<a> iLA;
    private float iLB;
    private int iLC;
    private TitleView iLs;
    private CommitView iLt;
    private LinearLayout iLu;
    private LinearLayout iLv;
    private ImageView iLw;
    private TextView iLx;
    private TextView iLy;
    private FormCard iLz;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean cgm();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.acW = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.iLB = 1.0f;
        this.iLC = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bIe() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.iLs = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.iLw = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.iLw.setEnabled(false);
        this.iLt = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.iLv = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.iLu = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.iLx = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.iLy = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.iLt != null) {
            this.iLt.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.iLA, FormCardView.this.iLt.getPostUrl(), FormCardView.this.acW);
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
        if (formCard != null && formCard.mIsLegal && this.iLz != formCard) {
            cgt();
            this.iLz = formCard;
            this.acW = formCard.getItemId();
            ch(formCard.mWidth, formCard.mHeight);
            this.iLs.au(this.iLB);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iLs.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iLB);
            }
            this.iLt.au(this.iLB);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iLt.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.iLB);
            }
            this.iLs.a(formCard.titleInfo);
            this.iLt.a(formCard.commitInfo);
            b.cfK().a(new com.baidu.tieba.recapp.a.a(this.iLt.getPostUrl()));
            cgq();
            cgs();
            cgr();
            a(this.iLs);
            a(this.iLt);
            if (formCard.isCommitSuccess()) {
                cgu();
            }
            if (!formCard.mHasShown) {
                r.cfJ().cfF().ce(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void ch(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.iLB = (float) (this.mScreenWidth / 750.0d);
    }

    private void cgq() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.iLz.backgroundInfo != null) {
            this.iLw.setVisibility(0);
            if (!TextUtils.isEmpty(this.iLz.backgroundInfo.img)) {
                c.fT().a(this.iLz.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.iLz.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.iLw.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iLw.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.iLw.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.iLw.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int bR = com.baidu.tieba.lego.card.d.a.bR(FormCardView.this.iLz.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.ve(bR)) {
                                            FormCardView.this.mRootView.setBackgroundColor(bR);
                                        }
                                        aVar.drawImageTo(FormCardView.this.iLw);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.iLw.setImageBitmap(null);
                                FormCardView.this.iLw.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.iLw.setImageBitmap(null);
                                FormCardView.this.iLw.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.iLw.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.iLw.setVisibility(8);
    }

    private void cgr() {
        FormCard.f fVar = this.iLz.resultInfo;
        float dimension = this.ceu.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.ceu.getResources().getDimension(R.dimen.fontsize28);
        int color = this.ceu.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.iLx.setText(fVar.title);
            this.iLx.setTextColor(-1);
            this.iLx.setTextSize(0, dimension);
            this.iLy.setText(fVar.desc);
            this.iLy.setTextColor(color);
            this.iLy.setTextSize(0, dimension2);
        }
    }

    private void cgs() {
        if (this.iLz.itemList != null && this.iLz.itemList.size() > 0) {
            int size = this.iLz.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.iLz.itemList.get(i);
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

    private void cgt() {
        this.iLv.removeAllViews();
        if (this.iLA != null) {
            this.iLA.clear();
        } else {
            this.iLA = new ArrayList();
        }
        this.iLt.setVisibility(0);
        this.iLv.setVisibility(0);
        this.iLu.setVisibility(8);
        this.iLt.setClickable(true);
        this.iLw.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.au(this.iLB);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.iLv.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.cgv());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.iLB);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.cgv()));
        }
    }

    public void a(a aVar) {
        if (this.iLA == null) {
            this.iLA = new ArrayList();
        }
        this.iLA.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject dM;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.cgm()) {
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
                this.iLt.setClickable(false);
                return;
            }
            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.iLt.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgu() {
        this.iLt.setVisibility(4);
        this.iLv.setVisibility(4);
        this.iLu.setVisibility(0);
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
            this.iLt.setClickable(true);
        } else {
            b.cfK().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.iLz.setCommitState(true);
                            FormCardView.this.cgu();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new e().showFailToast(hVar.errorString);
                            FormCardView.this.iLz.setCommitState(false);
                        } else {
                            new e().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.iLz.setCommitState(false);
                        }
                    }
                    FormCardView.this.iLt.setClickable(true);
                }
            });
        }
    }
}
