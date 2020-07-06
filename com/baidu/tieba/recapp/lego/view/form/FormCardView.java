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
/* loaded from: classes13.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String aOP;
    private TitleView lip;
    private CommitView liq;
    private LinearLayout lir;
    private LinearLayout lis;
    private ImageView lit;
    private TextView liu;
    private TextView liv;
    private FormCard liw;
    private List<a> lix;
    private float liy;
    private int liz;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes13.dex */
    public interface a {
        boolean cZs();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aOP = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.liy = 1.0f;
        this.liz = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cxz() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.lip = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.lit = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.lit.setEnabled(false);
        this.liq = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.lis = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.lir = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.liu = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.liv = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.liq != null) {
            this.liq.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.lix, FormCardView.this.liq.getPostUrl(), FormCardView.this.aOP);
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
        if (formCard != null && formCard.mIsLegal && this.liw != formCard) {
            cZz();
            this.liw = formCard;
            this.aOP = formCard.getItemId();
            cT(formCard.mWidth, formCard.mHeight);
            this.lip.ax(this.liy);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lip.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.liy);
            }
            this.liq.ax(this.liy);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.liq.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.liy);
            }
            this.lip.a(formCard.titleInfo);
            this.liq.a(formCard.commitInfo);
            b.cYU().a(new com.baidu.tieba.recapp.a.a(this.liq.getPostUrl()));
            cZw();
            cZy();
            cZx();
            a(this.lip);
            a(this.liq);
            if (formCard.isCommitSuccess()) {
                cZA();
            }
            if (!formCard.mHasShown) {
                q.cYT().cYP().dx(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cT(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.liy = (float) (this.mScreenWidth / 750.0d);
    }

    private void cZw() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.liw.backgroundInfo != null) {
            this.lit.setVisibility(0);
            if (!TextUtils.isEmpty(this.liw.backgroundInfo.img)) {
                c.ln().a(this.liw.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.liw.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.lit.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.lit.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.lit.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.lit.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int dV = com.baidu.tieba.lego.card.d.a.dV(FormCardView.this.liw.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.zv(dV)) {
                                            FormCardView.this.mRootView.setBackgroundColor(dV);
                                        }
                                        aVar.drawImageTo(FormCardView.this.lit);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.lit.setImageBitmap(null);
                                FormCardView.this.lit.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.lit.setImageBitmap(null);
                                FormCardView.this.lit.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.lit.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.lit.setVisibility(8);
    }

    private void cZx() {
        FormCard.f fVar = this.liw.resultInfo;
        float dimension = this.dPv.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.dPv.getResources().getDimension(R.dimen.fontsize28);
        int color = this.dPv.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.liu.setText(fVar.title);
            this.liu.setTextColor(-1);
            this.liu.setTextSize(0, dimension);
            this.liv.setText(fVar.desc);
            this.liv.setTextColor(color);
            this.liv.setTextSize(0, dimension2);
        }
    }

    private void cZy() {
        if (this.liw.itemList != null && this.liw.itemList.size() > 0) {
            int size = this.liw.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.liw.itemList.get(i);
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

    private void cZz() {
        this.lis.removeAllViews();
        if (this.lix != null) {
            this.lix.clear();
        } else {
            this.lix = new ArrayList();
        }
        this.liq.setVisibility(0);
        this.lis.setVisibility(0);
        this.lir.setVisibility(8);
        this.liq.setClickable(true);
        this.lit.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.ax(this.liy);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.lis.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.cZB());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.liy);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.cZB()));
        }
    }

    public void a(a aVar) {
        if (this.lix == null) {
            this.lix = new ArrayList();
        }
        this.lix.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject fl;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.cZs()) {
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
                    if (formView2 != null && (fl = fl(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(fl);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.liq.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.liq.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZA() {
        this.liq.setVisibility(4);
        this.lis.setVisibility(4);
        this.lir.setVisibility(0);
    }

    private JSONObject fl(String str, String str2) {
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
            this.liq.setClickable(true);
        } else {
            b.cYU().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.liw.setCommitState(true);
                            FormCardView.this.cZA();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.liw.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.liw.setCommitState(false);
                        }
                    }
                    FormCardView.this.liq.setClickable(true);
                }
            });
        }
    }
}
