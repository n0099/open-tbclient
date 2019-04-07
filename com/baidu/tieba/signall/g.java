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
    private SignAllForumActivity ixT;
    private c ixz;
    private ArrayList<d> ezS = new ArrayList<>();
    private HashMap<String, SignSingleModel> ixU = new HashMap<>();
    private boolean eKK = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.ixT = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.ixz = cVar;
            this.ezS = cVar.cbJ();
            if (this.ezS.size() == 0) {
                this.eKK = false;
            } else {
                this.eKK = true;
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
        if (this.eKK) {
            return this.ezS.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ezS.size() > i) {
            return this.ezS.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View za(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.ixT.getPageContext().getPageActivity()).inflate(d.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.iya = (BarImageView) inflate.findViewById(d.g.signallforum_item_avatar);
            bVar.iya.setIsRound(false);
            bVar.iya.setGifIconSupport(false);
            bVar.iyc = (TextView) inflate.findViewById(d.g.signallforum_item_name);
            bVar.iyd = (ImageView) inflate.findViewById(d.g.signallforum_item_level);
            bVar.iye = (TextView) inflate.findViewById(d.g.signallforum_item_exp);
            bVar.iyf = (FrameLayout) inflate.findViewById(d.g.signallforum_item_res_container);
            bVar.iyg = (TextView) inflate.findViewById(d.g.signallforum_item_days);
            bVar.iyh = (RelativeLayout) inflate.findViewById(d.g.signallforum_item_resign_container);
            bVar.iyi = (ImageView) inflate.findViewById(d.g.signallforum_item_resign_icon);
            bVar.iyj = (ProgressBar) inflate.findViewById(d.g.signallforum_item_resign_progress);
            bVar.iyk = (TextView) inflate.findViewById(d.g.signallforum_item_resign_text);
            bVar.iyl = (TextView) inflate.findViewById(d.g.signallforum_item_error);
            bVar.iyb = (LinearLayout) inflate.findViewById(d.g.signallforum_item_level_container);
            bVar.iym = (TextView) inflate.findViewById(d.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.ixT.getPageContext().getPageActivity()).inflate(d.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.ixY = (TextView) inflate2.findViewById(d.g.signallforum_head_title);
        aVar.ixZ = (TextView) inflate2.findViewById(d.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.ixT.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ixT.getLayoutMode().onModeChanged(view);
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
            bVar.iyc.setText(str);
            al.c(bVar.iyd, BitmapHelper.getSmallGradeResourceIdNew(dVar.cbW()));
            bVar.iye.setText(dVar.cbX() + "/" + dVar.cbY());
            bVar.iym.clearAnimation();
            if (dVar.aCg()) {
                bVar.iyb.setVisibility(0);
                bVar.iyl.setVisibility(8);
                bVar.iyg.setVisibility(0);
                bVar.iyh.setVisibility(8);
                bVar.iyg.setText(String.format(this.ixT.getPageContext().getString(d.j.signallforum_days), Integer.valueOf(dVar.cbV())));
                if (dVar.ccc()) {
                    bVar.iye.setText(this.ixT.getPageContext().getString(d.j.signallforum_uplevel));
                    bVar.iym.setVisibility(8);
                } else {
                    bVar.iye.setText(dVar.cbX() + "/" + dVar.cbY());
                    bVar.iym.setVisibility(0);
                }
                int ccb = dVar.ccb();
                if (ccb > 0) {
                    bVar.iym.setVisibility(0);
                    bVar.iym.setText("+" + ccb);
                } else {
                    bVar.iym.setVisibility(8);
                }
            } else if (dVar.cbZ()) {
                bVar.iyb.setVisibility(0);
                bVar.iyl.setVisibility(8);
                bVar.iym.setVisibility(8);
                bVar.iyg.setVisibility(8);
                bVar.iyh.setVisibility(0);
                if (dVar.cca()) {
                    bVar.iyi.setVisibility(4);
                    bVar.iyj.setVisibility(0);
                    bVar.iyk.setText(d.j.signallforum_resigning);
                } else {
                    bVar.iyi.setVisibility(0);
                    bVar.iyj.setVisibility(4);
                    bVar.iyk.setText(d.j.signallforum_resign);
                }
                bVar.iyh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.cca()) {
                            bVar.iyi.setVisibility(4);
                            bVar.iyj.setVisibility(0);
                            bVar.iyk.setText(d.j.signallforum_resigning);
                            dVar.pL(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.ixT);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.ixU.put(str2, signSingleModel);
                            }
                            signSingleModel.dR(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.iyg.setVisibility(8);
                bVar.iyh.setVisibility(8);
                bVar.iym.setVisibility(8);
                bVar.iyb.setVisibility(0);
                bVar.iyl.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.iya.setTag(avatar);
            bVar.iya.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.eKK) {
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
            this.ixT.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.ixT.getLayoutMode().onModeChanged(view2.findViewById(d.g.sign_all_forum_tip));
            aVar.ixY.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            o(aVar.ixZ, i);
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
        int level = this.ixz == null ? 7 : this.ixz.getLevel();
        if (this.ezS == null || this.ezS.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.ezS.iterator();
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
            format = String.format(this.ixT.getPageContext().getString(d.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.ixT.getPageContext().getString(d.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View aYL() {
        View inflate = LayoutInflater.from(this.ixT.getPageContext().getPageActivity()).inflate(d.h.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.ixT.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(d.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.ad(d.j.sign_all_forum_nodata_tip, d.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ixT.getLayoutMode().setNightMode(skinType == 1);
        this.ixT.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.ixT.getPageContext(), skinType);
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
        public BarImageView iya;
        public LinearLayout iyb;
        public TextView iyc;
        public ImageView iyd;
        public TextView iye;
        public FrameLayout iyf;
        public TextView iyg;
        public RelativeLayout iyh;
        public ImageView iyi;
        public ProgressBar iyj;
        public TextView iyk;
        public TextView iyl;
        public TextView iym;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a {
        public TextView ixY;
        public TextView ixZ;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.ixU.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void dQ(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.ixT.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.ixU.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.ezS.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.ezS.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.pJ(z);
                dVar.pK(!z);
                dVar.pL(false);
                if (z) {
                    dVar.yX(signData.count_sign_num);
                    dVar.yZ(signData.sign_bonus_point);
                    dVar.yW(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cbM = this.ixz.cbM();
                    if (cbM.contains(dVar)) {
                        cbM.remove(dVar);
                        this.ixz.cbL().add(dVar);
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
                for (Map.Entry<String, SignSingleModel> entry : this.ixU.entrySet()) {
                    entry.getValue().ccC();
                }
                this.ixU.clear();
            }
        }
    }
}
