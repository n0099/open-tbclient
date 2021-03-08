package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
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
import com.baidu.tieba.recapp.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String aZu;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;
    private TitleView mYd;
    private CommitView mYe;
    private LinearLayout mYf;
    private LinearLayout mYg;
    private ImageView mYh;
    private TextView mYi;
    private TextView mYj;
    private FormCard mYk;
    private List<a> mYl;
    private float mYm;
    private int mYn;

    /* loaded from: classes7.dex */
    public interface a {
        boolean dDZ();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aZu = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.mYm = 1.0f;
        this.mYn = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dce() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.mYd = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.mYh = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.mYh.setEnabled(false);
        this.mYe = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.mYg = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.mYf = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.mYi = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.mYj = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.mYe != null) {
            this.mYe.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.mYl, FormCardView.this.mYe.getPostUrl(), FormCardView.this.aZu);
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
        if (formCard != null && formCard.mIsLegal && this.mYk != formCard) {
            dEg();
            this.mYk = formCard;
            this.aZu = formCard.getItemId();
            dj(formCard.mWidth, formCard.mHeight);
            this.mYd.bd(this.mYm);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mYd.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mYm);
            }
            this.mYe.bd(this.mYm);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mYe.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mYm);
            }
            this.mYd.a(formCard.titleInfo);
            this.mYe.a(formCard.commitInfo);
            b.dDD().a(new com.baidu.tieba.recapp.a.a(this.mYe.getPostUrl()));
            dEd();
            dEf();
            dEe();
            a(this.mYd);
            a(this.mYe);
            if (formCard.isCommitSuccess()) {
                dEh();
            }
            if (!formCard.mHasShown) {
                s.dDB().dDx().eh(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void dj(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.mYm = (float) (this.mScreenWidth / 750.0d);
    }

    private void dEd() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.mYk.backgroundInfo != null) {
            this.mYh.setVisibility(0);
            if (!TextUtils.isEmpty(this.mYk.backgroundInfo.img)) {
                d.mw().a(this.mYk.backgroundInfo.img, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.c
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.getRawBitmap() != null) {
                                    int height = aVar.getRawBitmap().getHeight();
                                    int width = aVar.getRawBitmap().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.mYk.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.mYh.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mYh.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.mYh.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mYh.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int rT = com.baidu.tieba.lego.card.c.b.rT(FormCardView.this.mYk.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.c.b.DW(rT)) {
                                            FormCardView.this.mRootView.setBackgroundColor(rT);
                                        }
                                        aVar.drawImageTo(FormCardView.this.mYh);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.mYh.setImageBitmap(null);
                                FormCardView.this.mYh.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.mYh.setImageBitmap(null);
                                FormCardView.this.mYh.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.mYh.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.mYh.setVisibility(8);
    }

    private void dEe() {
        FormCard.f fVar = this.mYk.resultInfo;
        float dimension = this.eWx.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.eWx.getResources().getDimension(R.dimen.fontsize28);
        int color = this.eWx.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.mYi.setText(fVar.title);
            this.mYi.setTextColor(-1);
            this.mYi.setTextSize(0, dimension);
            this.mYj.setText(fVar.desc);
            this.mYj.setTextColor(color);
            this.mYj.setTextSize(0, dimension2);
        }
    }

    private void dEf() {
        if (this.mYk.itemList != null && this.mYk.itemList.size() > 0) {
            int size = this.mYk.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.mYk.itemList.get(i);
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

    private void dEg() {
        this.mYg.removeAllViews();
        if (this.mYl != null) {
            com.baidu.tieba.lego.card.c.a.clear(this.mYl);
        } else {
            this.mYl = new ArrayList();
        }
        this.mYe.setVisibility(0);
        this.mYg.setVisibility(0);
        this.mYf.setVisibility(8);
        this.mYe.setClickable(true);
        this.mYh.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.bd(this.mYm);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.mYg.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.dEi());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.mYm);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.dEi()));
        }
    }

    public void a(a aVar) {
        if (this.mYl == null) {
            this.mYl = new ArrayList();
        }
        com.baidu.tieba.lego.card.c.a.a(this.mYl, aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject gl;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.dDZ()) {
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
                    if (formView2 != null && (gl = gl(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(gl);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                f(str, hashMap);
                this.mYe.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.mYe.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEh() {
        this.mYe.setVisibility(4);
        this.mYg.setVisibility(4);
        this.mYf.setVisibility(0);
    }

    private JSONObject gl(String str, String str2) {
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

    private void f(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.mYe.setClickable(true);
        } else {
            b.dDD().a(null, str, hashMap, new e() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.mYk.setCommitState(true);
                            FormCardView.this.dEh();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.mYk.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.mYk.setCommitState(false);
                        }
                    }
                    FormCardView.this.mYe.setClickable(true);
                }
            });
        }
    }
}
