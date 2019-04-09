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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private boolean isDestory;
    private c ixA;
    private SignAllForumActivity ixU;
    private ArrayList<d> ezT = new ArrayList<>();
    private HashMap<String, SignSingleModel> ixV = new HashMap<>();
    private boolean eKL = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.ixU = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.ixA = cVar;
            this.ezT = cVar.cbJ();
            if (this.ezT.size() == 0) {
                this.eKL = false;
            } else {
                this.eKL = true;
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
        if (this.eKL) {
            return this.ezT.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ezT.size() > i) {
            return this.ezT.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View za(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.ixU.getPageContext().getPageActivity()).inflate(d.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.iyb = (BarImageView) inflate.findViewById(d.g.signallforum_item_avatar);
            bVar.iyb.setIsRound(false);
            bVar.iyb.setGifIconSupport(false);
            bVar.iyd = (TextView) inflate.findViewById(d.g.signallforum_item_name);
            bVar.iye = (ImageView) inflate.findViewById(d.g.signallforum_item_level);
            bVar.iyf = (TextView) inflate.findViewById(d.g.signallforum_item_exp);
            bVar.iyg = (FrameLayout) inflate.findViewById(d.g.signallforum_item_res_container);
            bVar.iyh = (TextView) inflate.findViewById(d.g.signallforum_item_days);
            bVar.iyi = (RelativeLayout) inflate.findViewById(d.g.signallforum_item_resign_container);
            bVar.iyj = (ImageView) inflate.findViewById(d.g.signallforum_item_resign_icon);
            bVar.iyk = (ProgressBar) inflate.findViewById(d.g.signallforum_item_resign_progress);
            bVar.iyl = (TextView) inflate.findViewById(d.g.signallforum_item_resign_text);
            bVar.iym = (TextView) inflate.findViewById(d.g.signallforum_item_error);
            bVar.iyc = (LinearLayout) inflate.findViewById(d.g.signallforum_item_level_container);
            bVar.iyn = (TextView) inflate.findViewById(d.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.ixU.getPageContext().getPageActivity()).inflate(d.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.ixZ = (TextView) inflate2.findViewById(d.g.signallforum_head_title);
        aVar.iya = (TextView) inflate2.findViewById(d.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.ixU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ixU.getLayoutMode().onModeChanged(view);
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
                        str = forumName.substring(0, i3) + "...";
                        break;
                    }
                }
            }
            str = forumName;
            bVar.iyd.setText(str);
            al.c(bVar.iye, BitmapHelper.getSmallGradeResourceIdNew(dVar.cbW()));
            bVar.iyf.setText(dVar.cbX() + "/" + dVar.cbY());
            bVar.iyn.clearAnimation();
            if (dVar.aCg()) {
                bVar.iyc.setVisibility(0);
                bVar.iym.setVisibility(8);
                bVar.iyh.setVisibility(0);
                bVar.iyi.setVisibility(8);
                bVar.iyh.setText(String.format(this.ixU.getPageContext().getString(d.j.signallforum_days), Integer.valueOf(dVar.cbV())));
                if (dVar.ccc()) {
                    bVar.iyf.setText(this.ixU.getPageContext().getString(d.j.signallforum_uplevel));
                    bVar.iyn.setVisibility(8);
                } else {
                    bVar.iyf.setText(dVar.cbX() + "/" + dVar.cbY());
                    bVar.iyn.setVisibility(0);
                }
                int ccb = dVar.ccb();
                if (ccb > 0) {
                    bVar.iyn.setVisibility(0);
                    bVar.iyn.setText("+" + ccb);
                } else {
                    bVar.iyn.setVisibility(8);
                }
            } else if (dVar.cbZ()) {
                bVar.iyc.setVisibility(0);
                bVar.iym.setVisibility(8);
                bVar.iyn.setVisibility(8);
                bVar.iyh.setVisibility(8);
                bVar.iyi.setVisibility(0);
                if (dVar.cca()) {
                    bVar.iyj.setVisibility(4);
                    bVar.iyk.setVisibility(0);
                    bVar.iyl.setText(d.j.signallforum_resigning);
                } else {
                    bVar.iyj.setVisibility(0);
                    bVar.iyk.setVisibility(4);
                    bVar.iyl.setText(d.j.signallforum_resign);
                }
                bVar.iyi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.cca()) {
                            bVar.iyj.setVisibility(4);
                            bVar.iyk.setVisibility(0);
                            bVar.iyl.setText(d.j.signallforum_resigning);
                            dVar.pL(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.ixU);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.ixV.put(str2, signSingleModel);
                            }
                            signSingleModel.dR(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.iyh.setVisibility(8);
                bVar.iyi.setVisibility(8);
                bVar.iyn.setVisibility(8);
                bVar.iyc.setVisibility(0);
                bVar.iym.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.iyb.setTag(avatar);
            bVar.iyb.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.eKL) {
            return aYL();
        }
        int itemViewType = getItemViewType(i);
        View za = view == null ? za(itemViewType) : view;
        if (itemViewType == 1) {
            if (za.getTag() != null && (za.getTag() instanceof a)) {
                view2 = za;
                aVar = (a) za.getTag();
            } else {
                View za2 = za(itemViewType);
                view2 = za2;
                aVar = (a) za2.getTag();
            }
            this.ixU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.ixU.getLayoutMode().onModeChanged(view2.findViewById(d.g.sign_all_forum_tip));
            aVar.ixZ.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            o(aVar.iya, i);
            return view2;
        }
        if (za.getTag() == null || !(za.getTag() instanceof b)) {
            za = za(itemViewType);
        }
        a(za, viewGroup, i);
        return za;
    }

    private void o(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.ixA == null ? 7 : this.ixA.getLevel();
        if (this.ezT == null || this.ezT.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.ezT.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.cbW() >= level) {
                        if (next.aCg()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aCg()) {
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
            format = String.format(this.ixU.getPageContext().getString(d.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.ixU.getPageContext().getString(d.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View aYL() {
        View inflate = LayoutInflater.from(this.ixU.getPageContext().getPageActivity()).inflate(d.h.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.ixU.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(d.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.ad(d.j.sign_all_forum_nodata_tip, d.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ixU.getLayoutMode().setNightMode(skinType == 1);
        this.ixU.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.ixU.getPageContext(), skinType);
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
    /* loaded from: classes6.dex */
    public class b {
        public BarImageView iyb;
        public LinearLayout iyc;
        public TextView iyd;
        public ImageView iye;
        public TextView iyf;
        public FrameLayout iyg;
        public TextView iyh;
        public RelativeLayout iyi;
        public ImageView iyj;
        public ProgressBar iyk;
        public TextView iyl;
        public TextView iym;
        public TextView iyn;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a {
        public TextView ixZ;
        public TextView iya;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.ixV.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void dQ(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.ixU.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.ixV.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.ezT.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.ezT.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.pJ(z);
                dVar.pK(!z);
                dVar.pL(false);
                if (z) {
                    dVar.yX(signData.count_sign_num);
                    dVar.yZ(signData.sign_bonus_point);
                    dVar.yW(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cbM = this.ixA.cbM();
                    if (cbM.contains(dVar)) {
                        cbM.remove(dVar);
                        this.ixA.cbL().add(dVar);
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

    public void cci() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.ixV.entrySet()) {
                    entry.getValue().ccC();
                }
                this.ixV.clear();
            }
        }
    }
}
