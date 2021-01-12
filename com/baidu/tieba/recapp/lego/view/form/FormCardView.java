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
import com.baidu.tieba.recapp.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String aUM;
    private Activity mActivity;
    private TitleView mMd;
    private CommitView mMe;
    private LinearLayout mMf;
    private LinearLayout mMg;
    private ImageView mMh;
    private TextView mMi;
    private TextView mMj;
    private FormCard mMk;
    private List<a> mMl;
    private float mMm;
    private int mMn;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes7.dex */
    public interface a {
        boolean dBB();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aUM = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.mMm = 1.0f;
        this.mMn = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZQ() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.mMd = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.mMh = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.mMh.setEnabled(false);
        this.mMe = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.mMg = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.mMf = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.mMi = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.mMj = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.mMe != null) {
            this.mMe.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.mMl, FormCardView.this.mMe.getPostUrl(), FormCardView.this.aUM);
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
        if (formCard != null && formCard.mIsLegal && this.mMk != formCard) {
            dBI();
            this.mMk = formCard;
            this.aUM = formCard.getItemId();
            dl(formCard.mWidth, formCard.mHeight);
            this.mMd.aW(this.mMm);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mMd.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mMm);
            }
            this.mMe.aW(this.mMm);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mMe.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mMm);
            }
            this.mMd.a(formCard.titleInfo);
            this.mMe.a(formCard.commitInfo);
            b.dBf().a(new com.baidu.tieba.recapp.a.a(this.mMe.getPostUrl()));
            dBF();
            dBH();
            dBG();
            a(this.mMd);
            a(this.mMe);
            if (formCard.isCommitSuccess()) {
                dBJ();
            }
            if (!formCard.mHasShown) {
                r.dBe().dBa().ej(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void dl(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.mMm = (float) (this.mScreenWidth / 750.0d);
    }

    private void dBF() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.mMk.backgroundInfo != null) {
            this.mMh.setVisibility(0);
            if (!TextUtils.isEmpty(this.mMk.backgroundInfo.img)) {
                d.mx().a(this.mMk.backgroundInfo.img, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.mMk.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.mMh.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mMh.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.mMh.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mMh.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int rt = com.baidu.tieba.lego.card.c.b.rt(FormCardView.this.mMk.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.c.b.DB(rt)) {
                                            FormCardView.this.mRootView.setBackgroundColor(rt);
                                        }
                                        aVar.drawImageTo(FormCardView.this.mMh);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.mMh.setImageBitmap(null);
                                FormCardView.this.mMh.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.mMh.setImageBitmap(null);
                                FormCardView.this.mMh.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.mMh.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.mMh.setVisibility(8);
    }

    private void dBG() {
        FormCard.f fVar = this.mMk.resultInfo;
        float dimension = this.eSJ.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.eSJ.getResources().getDimension(R.dimen.fontsize28);
        int color = this.eSJ.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.mMi.setText(fVar.title);
            this.mMi.setTextColor(-1);
            this.mMi.setTextSize(0, dimension);
            this.mMj.setText(fVar.desc);
            this.mMj.setTextColor(color);
            this.mMj.setTextSize(0, dimension2);
        }
    }

    private void dBH() {
        if (this.mMk.itemList != null && this.mMk.itemList.size() > 0) {
            int size = this.mMk.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.mMk.itemList.get(i);
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

    private void dBI() {
        this.mMg.removeAllViews();
        if (this.mMl != null) {
            com.baidu.tieba.lego.card.c.a.clear(this.mMl);
        } else {
            this.mMl = new ArrayList();
        }
        this.mMe.setVisibility(0);
        this.mMg.setVisibility(0);
        this.mMf.setVisibility(8);
        this.mMe.setClickable(true);
        this.mMh.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aW(this.mMm);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.mMg.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.dBK());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.mMm);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.dBK()));
        }
    }

    public void a(a aVar) {
        if (this.mMl == null) {
            this.mMl = new ArrayList();
        }
        com.baidu.tieba.lego.card.c.a.a(this.mMl, aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject ge;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.dBB()) {
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
                    if (formView2 != null && (ge = ge(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(ge);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.mMe.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.mMe.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBJ() {
        this.mMe.setVisibility(4);
        this.mMg.setVisibility(4);
        this.mMf.setVisibility(0);
    }

    private JSONObject ge(String str, String str2) {
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
            this.mMe.setClickable(true);
        } else {
            b.dBf().a(null, str, hashMap, new e() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.mMk.setCommitState(true);
                            FormCardView.this.dBJ();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.mMk.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.mMk.setCommitState(false);
                        }
                    }
                    FormCardView.this.mMe.setClickable(true);
                }
            });
        }
    }
}
