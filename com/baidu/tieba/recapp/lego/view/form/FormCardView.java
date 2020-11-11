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
    private String aWy;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;
    private TitleView mwZ;
    private CommitView mxa;
    private LinearLayout mxb;
    private LinearLayout mxc;
    private ImageView mxd;
    private TextView mxe;
    private TextView mxf;
    private FormCard mxg;
    private List<a> mxh;
    private float mxi;
    private int mxj;

    /* loaded from: classes26.dex */
    public interface a {
        boolean dAO();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aWy = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.mxi = 1.0f;
        this.mxj = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZo() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.mwZ = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.mxd = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.mxd.setEnabled(false);
        this.mxa = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.mxc = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.mxb = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.mxe = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.mxf = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.mxa != null) {
            this.mxa.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.mxh, FormCardView.this.mxa.getPostUrl(), FormCardView.this.aWy);
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
        if (formCard != null && formCard.mIsLegal && this.mxg != formCard) {
            dAV();
            this.mxg = formCard;
            this.aWy = formCard.getItemId();
            dk(formCard.mWidth, formCard.mHeight);
            this.mwZ.aM(this.mxi);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mwZ.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mxi);
            }
            this.mxa.aM(this.mxi);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mxa.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mxi);
            }
            this.mwZ.a(formCard.titleInfo);
            this.mxa.a(formCard.commitInfo);
            b.dAp().a(new com.baidu.tieba.recapp.a.a(this.mxa.getPostUrl()));
            dAS();
            dAU();
            dAT();
            a(this.mwZ);
            a(this.mxa);
            if (formCard.isCommitSuccess()) {
                dAW();
            }
            if (!formCard.mHasShown) {
                r.dAo().dAk().ed(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void dk(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.mxi = (float) (this.mScreenWidth / 750.0d);
    }

    private void dAS() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.mxg.backgroundInfo != null) {
            this.mxd.setVisibility(0);
            if (!TextUtils.isEmpty(this.mxg.backgroundInfo.img)) {
                c.mS().a(this.mxg.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.mxg.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.mxd.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mxd.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.mxd.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mxd.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int fv = com.baidu.tieba.lego.card.d.b.fv(FormCardView.this.mxg.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.b.Ea(fv)) {
                                            FormCardView.this.mRootView.setBackgroundColor(fv);
                                        }
                                        aVar.drawImageTo(FormCardView.this.mxd);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.mxd.setImageBitmap(null);
                                FormCardView.this.mxd.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.mxd.setImageBitmap(null);
                                FormCardView.this.mxd.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.mxd.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.mxd.setVisibility(8);
    }

    private void dAT() {
        FormCard.f fVar = this.mxg.resultInfo;
        float dimension = this.eIc.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.eIc.getResources().getDimension(R.dimen.fontsize28);
        int color = this.eIc.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.mxe.setText(fVar.title);
            this.mxe.setTextColor(-1);
            this.mxe.setTextSize(0, dimension);
            this.mxf.setText(fVar.desc);
            this.mxf.setTextColor(color);
            this.mxf.setTextSize(0, dimension2);
        }
    }

    private void dAU() {
        if (this.mxg.itemList != null && this.mxg.itemList.size() > 0) {
            int size = this.mxg.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.mxg.itemList.get(i);
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

    private void dAV() {
        this.mxc.removeAllViews();
        if (this.mxh != null) {
            com.baidu.tieba.lego.card.d.a.clear(this.mxh);
        } else {
            this.mxh = new ArrayList();
        }
        this.mxa.setVisibility(0);
        this.mxc.setVisibility(0);
        this.mxb.setVisibility(8);
        this.mxa.setClickable(true);
        this.mxd.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aM(this.mxi);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.mxc.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.dAX());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.mxi);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.dAX()));
        }
    }

    public void a(a aVar) {
        if (this.mxh == null) {
            this.mxh = new ArrayList();
        }
        com.baidu.tieba.lego.card.d.a.a(this.mxh, aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject gd;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.dAO()) {
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
                    if (formView2 != null && (gd = gd(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(gd);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.mxa.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.mxa.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAW() {
        this.mxa.setVisibility(4);
        this.mxc.setVisibility(4);
        this.mxb.setVisibility(0);
    }

    private JSONObject gd(String str, String str2) {
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
            this.mxa.setClickable(true);
        } else {
            b.dAp().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.mxg.setCommitState(true);
                            FormCardView.this.dAW();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.mxg.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.mxg.setCommitState(false);
                        }
                    }
                    FormCardView.this.mxa.setClickable(true);
                }
            });
        }
    }
}
