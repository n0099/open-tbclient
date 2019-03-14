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
    private c ixP;
    private SignAllForumActivity iyj;
    private ArrayList<d> eAh = new ArrayList<>();
    private HashMap<String, SignSingleModel> iyk = new HashMap<>();
    private boolean eKY = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.iyj = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.ixP = cVar;
            this.eAh = cVar.cbN();
            if (this.eAh.size() == 0) {
                this.eKY = false;
            } else {
                this.eKY = true;
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
        if (this.eKY) {
            return this.eAh.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eAh.size() > i) {
            return this.eAh.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View ze(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.iyj.getPageContext().getPageActivity()).inflate(d.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.iyq = (BarImageView) inflate.findViewById(d.g.signallforum_item_avatar);
            bVar.iyq.setIsRound(false);
            bVar.iyq.setGifIconSupport(false);
            bVar.iys = (TextView) inflate.findViewById(d.g.signallforum_item_name);
            bVar.iyt = (ImageView) inflate.findViewById(d.g.signallforum_item_level);
            bVar.iyu = (TextView) inflate.findViewById(d.g.signallforum_item_exp);
            bVar.iyv = (FrameLayout) inflate.findViewById(d.g.signallforum_item_res_container);
            bVar.iyw = (TextView) inflate.findViewById(d.g.signallforum_item_days);
            bVar.iyx = (RelativeLayout) inflate.findViewById(d.g.signallforum_item_resign_container);
            bVar.iyy = (ImageView) inflate.findViewById(d.g.signallforum_item_resign_icon);
            bVar.iyz = (ProgressBar) inflate.findViewById(d.g.signallforum_item_resign_progress);
            bVar.iyA = (TextView) inflate.findViewById(d.g.signallforum_item_resign_text);
            bVar.iyB = (TextView) inflate.findViewById(d.g.signallforum_item_error);
            bVar.iyr = (LinearLayout) inflate.findViewById(d.g.signallforum_item_level_container);
            bVar.iyC = (TextView) inflate.findViewById(d.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.iyj.getPageContext().getPageActivity()).inflate(d.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.iyo = (TextView) inflate2.findViewById(d.g.signallforum_head_title);
        aVar.iyp = (TextView) inflate2.findViewById(d.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.iyj.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iyj.getLayoutMode().onModeChanged(view);
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
            bVar.iys.setText(str);
            al.c(bVar.iyt, BitmapHelper.getSmallGradeResourceIdNew(dVar.cca()));
            bVar.iyu.setText(dVar.ccb() + "/" + dVar.ccc());
            bVar.iyC.clearAnimation();
            if (dVar.aCj()) {
                bVar.iyr.setVisibility(0);
                bVar.iyB.setVisibility(8);
                bVar.iyw.setVisibility(0);
                bVar.iyx.setVisibility(8);
                bVar.iyw.setText(String.format(this.iyj.getPageContext().getString(d.j.signallforum_days), Integer.valueOf(dVar.cbZ())));
                if (dVar.ccg()) {
                    bVar.iyu.setText(this.iyj.getPageContext().getString(d.j.signallforum_uplevel));
                    bVar.iyC.setVisibility(8);
                } else {
                    bVar.iyu.setText(dVar.ccb() + "/" + dVar.ccc());
                    bVar.iyC.setVisibility(0);
                }
                int ccf = dVar.ccf();
                if (ccf > 0) {
                    bVar.iyC.setVisibility(0);
                    bVar.iyC.setText("+" + ccf);
                } else {
                    bVar.iyC.setVisibility(8);
                }
            } else if (dVar.ccd()) {
                bVar.iyr.setVisibility(0);
                bVar.iyB.setVisibility(8);
                bVar.iyC.setVisibility(8);
                bVar.iyw.setVisibility(8);
                bVar.iyx.setVisibility(0);
                if (dVar.cce()) {
                    bVar.iyy.setVisibility(4);
                    bVar.iyz.setVisibility(0);
                    bVar.iyA.setText(d.j.signallforum_resigning);
                } else {
                    bVar.iyy.setVisibility(0);
                    bVar.iyz.setVisibility(4);
                    bVar.iyA.setText(d.j.signallforum_resign);
                }
                bVar.iyx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.cce()) {
                            bVar.iyy.setVisibility(4);
                            bVar.iyz.setVisibility(0);
                            bVar.iyA.setText(d.j.signallforum_resigning);
                            dVar.pL(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.iyj);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.iyk.put(str2, signSingleModel);
                            }
                            signSingleModel.dQ(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.iyw.setVisibility(8);
                bVar.iyx.setVisibility(8);
                bVar.iyC.setVisibility(8);
                bVar.iyr.setVisibility(0);
                bVar.iyB.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.iyq.setTag(avatar);
            bVar.iyq.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.eKY) {
            return aYO();
        }
        int itemViewType = getItemViewType(i);
        View ze = view == null ? ze(itemViewType) : view;
        if (itemViewType == 1) {
            if (ze.getTag() != null && (ze.getTag() instanceof a)) {
                view2 = ze;
                aVar = (a) ze.getTag();
            } else {
                View ze2 = ze(itemViewType);
                view2 = ze2;
                aVar = (a) ze2.getTag();
            }
            this.iyj.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.iyj.getLayoutMode().onModeChanged(view2.findViewById(d.g.sign_all_forum_tip));
            aVar.iyo.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            o(aVar.iyp, i);
            return view2;
        }
        if (ze.getTag() == null || !(ze.getTag() instanceof b)) {
            ze = ze(itemViewType);
        }
        a(ze, viewGroup, i);
        return ze;
    }

    private void o(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.ixP == null ? 7 : this.ixP.getLevel();
        if (this.eAh == null || this.eAh.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.eAh.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.cca() >= level) {
                        if (next.aCj()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aCj()) {
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
            format = String.format(this.iyj.getPageContext().getString(d.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.iyj.getPageContext().getString(d.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View aYO() {
        View inflate = LayoutInflater.from(this.iyj.getPageContext().getPageActivity()).inflate(d.h.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.iyj.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(d.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.ad(d.j.sign_all_forum_nodata_tip, d.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iyj.getLayoutMode().setNightMode(skinType == 1);
        this.iyj.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.iyj.getPageContext(), skinType);
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
        public TextView iyA;
        public TextView iyB;
        public TextView iyC;
        public BarImageView iyq;
        public LinearLayout iyr;
        public TextView iys;
        public ImageView iyt;
        public TextView iyu;
        public FrameLayout iyv;
        public TextView iyw;
        public RelativeLayout iyx;
        public ImageView iyy;
        public ProgressBar iyz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a {
        public TextView iyo;
        public TextView iyp;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.iyk.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void dP(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.iyj.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.iyk.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.eAh.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.eAh.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.pJ(z);
                dVar.pK(!z);
                dVar.pL(false);
                if (z) {
                    dVar.zb(signData.count_sign_num);
                    dVar.zd(signData.sign_bonus_point);
                    dVar.za(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cbQ = this.ixP.cbQ();
                    if (cbQ.contains(dVar)) {
                        cbQ.remove(dVar);
                        this.ixP.cbP().add(dVar);
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

    public void ccm() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.iyk.entrySet()) {
                    entry.getValue().ccG();
                }
                this.iyk.clear();
            }
        }
    }
}
