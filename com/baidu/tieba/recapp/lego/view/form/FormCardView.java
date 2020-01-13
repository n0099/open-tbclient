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
/* loaded from: classes11.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String alG;
    private TitleView jJj;
    private CommitView jJk;
    private LinearLayout jJl;
    private LinearLayout jJm;
    private ImageView jJn;
    private TextView jJo;
    private TextView jJp;
    private FormCard jJq;
    private List<a> jJr;
    private float jJs;
    private int jJt;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes11.dex */
    public interface a {
        boolean cBx();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.alG = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.jJs = 1.0f;
        this.jJt = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View caC() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.jJj = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.jJn = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.jJn.setEnabled(false);
        this.jJk = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.jJm = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.jJl = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.jJo = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.jJp = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.jJk != null) {
            this.jJk.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.jJr, FormCardView.this.jJk.getPostUrl(), FormCardView.this.alG);
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
        if (formCard != null && formCard.mIsLegal && this.jJq != formCard) {
            cBE();
            this.jJq = formCard;
            this.alG = formCard.getItemId();
            cA(formCard.mWidth, formCard.mHeight);
            this.jJj.aK(this.jJs);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jJj.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.jJs);
            }
            this.jJk.aK(this.jJs);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.jJk.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.jJs);
            }
            this.jJj.a(formCard.titleInfo);
            this.jJk.a(formCard.commitInfo);
            b.cAW().a(new com.baidu.tieba.recapp.a.a(this.jJk.getPostUrl()));
            cBB();
            cBD();
            cBC();
            a(this.jJj);
            a(this.jJk);
            if (formCard.isCommitSuccess()) {
                cBF();
            }
            if (!formCard.mHasShown) {
                r.cAV().cAR().cB(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cA(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.jJs = (float) (this.mScreenWidth / 750.0d);
    }

    private void cBB() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.jJq.backgroundInfo != null) {
            this.jJn.setVisibility(0);
            if (!TextUtils.isEmpty(this.jJq.backgroundInfo.img)) {
                c.gr().a(this.jJq.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.jJq.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.jJn.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.jJn.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.jJn.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.jJn.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int cy = com.baidu.tieba.lego.card.d.a.cy(FormCardView.this.jJq.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.xl(cy)) {
                                            FormCardView.this.mRootView.setBackgroundColor(cy);
                                        }
                                        aVar.drawImageTo(FormCardView.this.jJn);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.jJn.setImageBitmap(null);
                                FormCardView.this.jJn.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.jJn.setImageBitmap(null);
                                FormCardView.this.jJn.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.jJn.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.jJn.setVisibility(8);
    }

    private void cBC() {
        FormCard.f fVar = this.jJq.resultInfo;
        float dimension = this.cRe.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.cRe.getResources().getDimension(R.dimen.fontsize28);
        int color = this.cRe.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.jJo.setText(fVar.title);
            this.jJo.setTextColor(-1);
            this.jJo.setTextSize(0, dimension);
            this.jJp.setText(fVar.desc);
            this.jJp.setTextColor(color);
            this.jJp.setTextSize(0, dimension2);
        }
    }

    private void cBD() {
        if (this.jJq.itemList != null && this.jJq.itemList.size() > 0) {
            int size = this.jJq.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.jJq.itemList.get(i);
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

    private void cBE() {
        this.jJm.removeAllViews();
        if (this.jJr != null) {
            this.jJr.clear();
        } else {
            this.jJr = new ArrayList();
        }
        this.jJk.setVisibility(0);
        this.jJm.setVisibility(0);
        this.jJl.setVisibility(8);
        this.jJk.setClickable(true);
        this.jJn.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aK(this.jJs);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.jJm.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.cBG());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.jJs);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.cBG()));
        }
    }

    public void a(a aVar) {
        if (this.jJr == null) {
            this.jJr = new ArrayList();
        }
        this.jJr.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject eh;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.cBx()) {
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
                    if (formView2 != null && (eh = eh(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(eh);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.jJk.setClickable(false);
                return;
            }
            new d().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.jJk.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBF() {
        this.jJk.setVisibility(4);
        this.jJm.setVisibility(4);
        this.jJl.setVisibility(0);
    }

    private JSONObject eh(String str, String str2) {
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
            this.jJk.setClickable(true);
        } else {
            b.cAW().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.jJq.setCommitState(true);
                            FormCardView.this.cBF();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new d().showFailToast(hVar.errorString);
                            FormCardView.this.jJq.setCommitState(false);
                        } else {
                            new d().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.jJq.setCommitState(false);
                        }
                    }
                    FormCardView.this.jJk.setClickable(true);
                }
            });
        }
    }
}
