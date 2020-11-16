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
import com.baidu.tieba.recapp.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String aUN;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;
    private TitleView mxn;
    private CommitView mxo;
    private LinearLayout mxp;
    private LinearLayout mxq;
    private ImageView mxr;
    private TextView mxs;
    private TextView mxt;
    private FormCard mxu;
    private List<a> mxv;
    private float mxw;
    private int mxx;

    /* loaded from: classes25.dex */
    public interface a {
        boolean dAl();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aUN = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.mxw = 1.0f;
        this.mxx = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cYK() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.mxn = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.mxr = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.mxr.setEnabled(false);
        this.mxo = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.mxq = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.mxp = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.mxs = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.mxt = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.mxo != null) {
            this.mxo.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.mxv, FormCardView.this.mxo.getPostUrl(), FormCardView.this.aUN);
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
        if (formCard != null && formCard.mIsLegal && this.mxu != formCard) {
            dAs();
            this.mxu = formCard;
            this.aUN = formCard.getItemId();
            dk(formCard.mWidth, formCard.mHeight);
            this.mxn.aT(this.mxw);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mxn.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mxw);
            }
            this.mxo.aT(this.mxw);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mxo.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mxw);
            }
            this.mxn.a(formCard.titleInfo);
            this.mxo.a(formCard.commitInfo);
            b.dzP().a(new com.baidu.tieba.recapp.a.a(this.mxo.getPostUrl()));
            dAp();
            dAr();
            dAq();
            a(this.mxn);
            a(this.mxo);
            if (formCard.isCommitSuccess()) {
                dAt();
            }
            if (!formCard.mHasShown) {
                q.dzO().dzK().ed(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void dk(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.mxw = (float) (this.mScreenWidth / 750.0d);
    }

    private void dAp() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.mxu.backgroundInfo != null) {
            this.mxr.setVisibility(0);
            if (!TextUtils.isEmpty(this.mxu.backgroundInfo.img)) {
                c.mS().a(this.mxu.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.mxu.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.mxr.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mxr.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.mxr.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mxr.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int sa = com.baidu.tieba.lego.card.d.b.sa(FormCardView.this.mxu.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.b.Ey(sa)) {
                                            FormCardView.this.mRootView.setBackgroundColor(sa);
                                        }
                                        aVar.drawImageTo(FormCardView.this.mxr);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.mxr.setImageBitmap(null);
                                FormCardView.this.mxr.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.mxr.setImageBitmap(null);
                                FormCardView.this.mxr.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.mxr.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.mxr.setVisibility(8);
    }

    private void dAq() {
        FormCard.f fVar = this.mxu.resultInfo;
        float dimension = this.eGu.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.eGu.getResources().getDimension(R.dimen.fontsize28);
        int color = this.eGu.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.mxs.setText(fVar.title);
            this.mxs.setTextColor(-1);
            this.mxs.setTextSize(0, dimension);
            this.mxt.setText(fVar.desc);
            this.mxt.setTextColor(color);
            this.mxt.setTextSize(0, dimension2);
        }
    }

    private void dAr() {
        if (this.mxu.itemList != null && this.mxu.itemList.size() > 0) {
            int size = this.mxu.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.mxu.itemList.get(i);
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

    private void dAs() {
        this.mxq.removeAllViews();
        if (this.mxv != null) {
            com.baidu.tieba.lego.card.d.a.clear(this.mxv);
        } else {
            this.mxv = new ArrayList();
        }
        this.mxo.setVisibility(0);
        this.mxq.setVisibility(0);
        this.mxp.setVisibility(8);
        this.mxo.setClickable(true);
        this.mxr.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aT(this.mxw);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.mxq.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.dAu());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.mxw);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.dAu()));
        }
    }

    public void a(a aVar) {
        if (this.mxv == null) {
            this.mxv = new ArrayList();
        }
        com.baidu.tieba.lego.card.d.a.a(this.mxv, aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject gd;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.dAl()) {
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
                this.mxo.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.mxo.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAt() {
        this.mxo.setVisibility(4);
        this.mxq.setVisibility(4);
        this.mxp.setVisibility(0);
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
            this.mxo.setClickable(true);
        } else {
            b.dzP().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.mxu.setCommitState(true);
                            FormCardView.this.dAt();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.mxu.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.mxu.setCommitState(false);
                        }
                    }
                    FormCardView.this.mxo.setClickable(true);
                }
            });
        }
    }
}
