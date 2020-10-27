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
    private String aVg;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;
    private TitleView mrc;
    private CommitView mrd;
    private LinearLayout mre;
    private LinearLayout mrf;
    private ImageView mrg;
    private TextView mrh;
    private TextView mri;
    private FormCard mrj;
    private List<a> mrk;
    private float mrl;
    private int mrm;

    /* loaded from: classes26.dex */
    public interface a {
        boolean dym();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aVg = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.mrl = 1.0f;
        this.mrm = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cWN() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.mrc = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.mrg = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.mrg.setEnabled(false);
        this.mrd = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.mrf = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.mre = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.mrh = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.mri = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.mrd != null) {
            this.mrd.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.mrk, FormCardView.this.mrd.getPostUrl(), FormCardView.this.aVg);
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
        if (formCard != null && formCard.mIsLegal && this.mrj != formCard) {
            dyt();
            this.mrj = formCard;
            this.aVg = formCard.getItemId();
            di(formCard.mWidth, formCard.mHeight);
            this.mrc.aK(this.mrl);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mrc.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mrl);
            }
            this.mrd.aK(this.mrl);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mrd.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.mrl);
            }
            this.mrc.a(formCard.titleInfo);
            this.mrd.a(formCard.commitInfo);
            b.dxN().a(new com.baidu.tieba.recapp.a.a(this.mrd.getPostUrl()));
            dyq();
            dys();
            dyr();
            a(this.mrc);
            a(this.mrd);
            if (formCard.isCommitSuccess()) {
                dyu();
            }
            if (!formCard.mHasShown) {
                r.dxM().dxI().ed(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void di(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.mrl = (float) (this.mScreenWidth / 750.0d);
    }

    private void dyq() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.mrj.backgroundInfo != null) {
            this.mrg.setVisibility(0);
            if (!TextUtils.isEmpty(this.mrj.backgroundInfo.img)) {
                c.mS().a(this.mrj.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.mrj.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.mrg.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mrg.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.mrg.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.mrg.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int fv = com.baidu.tieba.lego.card.d.b.fv(FormCardView.this.mrj.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.b.DN(fv)) {
                                            FormCardView.this.mRootView.setBackgroundColor(fv);
                                        }
                                        aVar.drawImageTo(FormCardView.this.mrg);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.mrg.setImageBitmap(null);
                                FormCardView.this.mrg.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.mrg.setImageBitmap(null);
                                FormCardView.this.mrg.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.mrg.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.mrg.setVisibility(8);
    }

    private void dyr() {
        FormCard.f fVar = this.mrj.resultInfo;
        float dimension = this.eCn.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.eCn.getResources().getDimension(R.dimen.fontsize28);
        int color = this.eCn.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.mrh.setText(fVar.title);
            this.mrh.setTextColor(-1);
            this.mrh.setTextSize(0, dimension);
            this.mri.setText(fVar.desc);
            this.mri.setTextColor(color);
            this.mri.setTextSize(0, dimension2);
        }
    }

    private void dys() {
        if (this.mrj.itemList != null && this.mrj.itemList.size() > 0) {
            int size = this.mrj.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.mrj.itemList.get(i);
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

    private void dyt() {
        this.mrf.removeAllViews();
        if (this.mrk != null) {
            com.baidu.tieba.lego.card.d.a.clear(this.mrk);
        } else {
            this.mrk = new ArrayList();
        }
        this.mrd.setVisibility(0);
        this.mrf.setVisibility(0);
        this.mre.setVisibility(8);
        this.mrd.setClickable(true);
        this.mrg.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aK(this.mrl);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.mrf.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.dyv());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.mrl);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.dyv()));
        }
    }

    public void a(a aVar) {
        if (this.mrk == null) {
            this.mrk = new ArrayList();
        }
        com.baidu.tieba.lego.card.d.a.a(this.mrk, aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject gd;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.dym()) {
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
                this.mrd.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.mrd.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyu() {
        this.mrd.setVisibility(4);
        this.mrf.setVisibility(4);
        this.mre.setVisibility(0);
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
            this.mrd.setClickable(true);
        } else {
            b.dxN().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.mrj.setCommitState(true);
                            FormCardView.this.dyu();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.mrj.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.mrj.setCommitState(false);
                        }
                    }
                    FormCardView.this.mrd.setClickable(true);
                }
            });
        }
    }
}
