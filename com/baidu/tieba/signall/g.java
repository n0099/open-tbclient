package com.baidu.tieba.signall;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes11.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private boolean isDestory;
    private c lwP;
    private SignAllForumActivity lxm;
    private ArrayList<d> gZU = new ArrayList<>();
    private HashMap<String, SignSingleModel> lxn = new HashMap<>();
    private boolean hpj = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.lxm = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.lwP = cVar;
            this.gZU = cVar.dfd();
            if (this.gZU.size() == 0) {
                this.hpj = false;
            } else {
                this.hpj = true;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof com.baidu.tieba.signall.b ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hpj) {
            return this.gZU.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gZU.size() > i) {
            return this.gZU.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View EE(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.lxm.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.lxt = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.lxt.setIsRound(false);
            bVar.lxt.setGifIconSupport(false);
            bVar.lxv = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.lxw = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.lxx = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.lxy = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.lxz = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.lxA = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.lxB = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.lxC = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.lxD = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.lxE = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.lxu = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.lxF = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.lxm.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.lxr = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.lxs = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.lxm.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lxm.getLayoutMode().onModeChanged(view);
        final b bVar = (b) view.getTag();
        final d dVar = (d) getItem(i);
        if (dVar != null) {
            String forumName = dVar.getForumName();
            if (forumName != null && forumName.length() > 8) {
                char[] charArray = forumName.toCharArray();
                int i2 = 0;
                for (int i3 = 0; i3 < charArray.length; i3++) {
                    if (StringUtils.isChinese(charArray[i3])) {
                        i2 += 2;
                    } else {
                        i2++;
                    }
                    if (i2 > 16) {
                        str = forumName.substring(0, i3) + StringHelper.STRING_MORE;
                        break;
                    }
                }
            }
            str = forumName;
            bVar.lxv.setText(str);
            an.setImageResource(bVar.lxw, BitmapHelper.getSmallGradeResourceIdNew(dVar.dfq()));
            bVar.lxx.setText(dVar.dfr() + "/" + dVar.dfs());
            bVar.lxF.clearAnimation();
            if (dVar.bux()) {
                bVar.lxu.setVisibility(0);
                bVar.lxE.setVisibility(8);
                bVar.lxz.setVisibility(0);
                bVar.lxA.setVisibility(8);
                bVar.lxz.setText(String.format(this.lxm.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.dfp())));
                if (dVar.dfw()) {
                    bVar.lxx.setText(this.lxm.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.lxF.setVisibility(8);
                } else {
                    bVar.lxx.setText(dVar.dfr() + "/" + dVar.dfs());
                    bVar.lxF.setVisibility(0);
                }
                int dfv = dVar.dfv();
                if (dfv > 0) {
                    bVar.lxF.setVisibility(0);
                    bVar.lxF.setText("+" + dfv);
                } else {
                    bVar.lxF.setVisibility(8);
                }
            } else if (dVar.dft()) {
                bVar.lxu.setVisibility(0);
                bVar.lxE.setVisibility(8);
                bVar.lxF.setVisibility(8);
                bVar.lxz.setVisibility(8);
                bVar.lxA.setVisibility(0);
                if (dVar.dfu()) {
                    bVar.lxB.setVisibility(4);
                    bVar.lxC.setVisibility(0);
                    bVar.lxD.setText(R.string.signallforum_resigning);
                } else {
                    bVar.lxB.setVisibility(0);
                    bVar.lxC.setVisibility(4);
                    bVar.lxD.setText(R.string.signallforum_resign);
                }
                bVar.lxA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.dfu()) {
                            bVar.lxB.setVisibility(4);
                            bVar.lxC.setVisibility(0);
                            bVar.lxD.setText(R.string.signallforum_resigning);
                            dVar.uv(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.lxm);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.lxn.put(str2, signSingleModel);
                            }
                            signSingleModel.fs(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.lxz.setVisibility(8);
                bVar.lxA.setVisibility(8);
                bVar.lxF.setVisibility(8);
                bVar.lxu.setVisibility(0);
                bVar.lxE.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.lxt.setTag(avatar);
            bVar.lxt.setPlaceHolder(1);
            bVar.lxt.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.hpj) {
            return bUT();
        }
        int itemViewType = getItemViewType(i);
        View EE = view == null ? EE(itemViewType) : view;
        if (itemViewType == 1) {
            if (EE.getTag() != null && (EE.getTag() instanceof a)) {
                view2 = EE;
                aVar = (a) EE.getTag();
            } else {
                View EE2 = EE(itemViewType);
                view2 = EE2;
                aVar = (a) EE2.getTag();
            }
            this.lxm.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.lxm.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.lxr.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            j(aVar.lxs, i);
            return view2;
        }
        if (EE.getTag() == null || !(EE.getTag() instanceof b)) {
            EE = EE(itemViewType);
        }
        a(EE, viewGroup, i);
        return EE;
    }

    private void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.lwP == null ? 7 : this.lwP.getLevel();
        if (this.gZU == null || this.gZU.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.gZU.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.dfq() >= level) {
                        if (next.bux()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bux()) {
                        i3++;
                    } else {
                        i2++;
                    }
                    i5 = i5;
                    i4 = i4;
                    i3 = i3;
                    i2 = i2;
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.lxm.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.lxm.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bUT() {
        View inflate = LayoutInflater.from(this.lxm.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.lxm.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.lxm.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dm(null, this.lxm.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lxm.getLayoutMode().setNightMode(skinType == 1);
        this.lxm.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.lxm.getPageContext(), skinType);
        a2.setVisibility(0);
        a2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return inflate;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b {
        public RelativeLayout lxA;
        public ImageView lxB;
        public ProgressBar lxC;
        public TextView lxD;
        public TextView lxE;
        public TextView lxF;
        public BarImageView lxt;
        public LinearLayout lxu;
        public TextView lxv;
        public ImageView lxw;
        public TextView lxx;
        public FrameLayout lxy;
        public TextView lxz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a {
        public TextView lxr;
        public TextView lxs;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.lxn.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void fr(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.lxm.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.lxn.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.gZU.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.gZU.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.ut(z);
                dVar.uu(!z);
                dVar.uv(false);
                if (z) {
                    dVar.EB(signData.count_sign_num);
                    dVar.ED(signData.sign_bonus_point);
                    dVar.EA(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> dfg = this.lwP.dfg();
                    if (dfg.contains(dVar)) {
                        dfg.remove(dVar);
                        this.lwP.dff().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.isDestory) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void dfC() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.lxn.entrySet()) {
                    entry.getValue().dfV();
                }
                this.lxn.clear();
            }
        }
    }
}
