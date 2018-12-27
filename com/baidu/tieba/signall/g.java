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
import com.baidu.tieba.e;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c hfa;
    private SignAllForumActivity hfu;
    private boolean isDestory;
    private ArrayList<d> dpB = new ArrayList<>();
    private HashMap<String, SignSingleModel> hfv = new HashMap<>();
    private boolean cOG = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.hfu = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.hfa = cVar;
            this.dpB = cVar.bAn();
            if (this.dpB.size() == 0) {
                this.cOG = false;
            } else {
                this.cOG = true;
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
        if (this.cOG) {
            return this.dpB.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dpB.size() > i) {
            return this.dpB.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View vl(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.hfu.getPageContext().getPageActivity()).inflate(e.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.hfB = (BarImageView) inflate.findViewById(e.g.signallforum_item_avatar);
            bVar.hfB.setIsRound(false);
            bVar.hfB.setGifIconSupport(false);
            bVar.hfD = (TextView) inflate.findViewById(e.g.signallforum_item_name);
            bVar.hfE = (ImageView) inflate.findViewById(e.g.signallforum_item_level);
            bVar.hfF = (TextView) inflate.findViewById(e.g.signallforum_item_exp);
            bVar.hfG = (FrameLayout) inflate.findViewById(e.g.signallforum_item_res_container);
            bVar.hfH = (TextView) inflate.findViewById(e.g.signallforum_item_days);
            bVar.hfI = (RelativeLayout) inflate.findViewById(e.g.signallforum_item_resign_container);
            bVar.hfJ = (ImageView) inflate.findViewById(e.g.signallforum_item_resign_icon);
            bVar.hfK = (ProgressBar) inflate.findViewById(e.g.signallforum_item_resign_progress);
            bVar.hfL = (TextView) inflate.findViewById(e.g.signallforum_item_resign_text);
            bVar.hfM = (TextView) inflate.findViewById(e.g.signallforum_item_error);
            bVar.hfC = (LinearLayout) inflate.findViewById(e.g.signallforum_item_level_container);
            bVar.hfN = (TextView) inflate.findViewById(e.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.hfu.getPageContext().getPageActivity()).inflate(e.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.hfz = (TextView) inflate2.findViewById(e.g.signallforum_head_title);
        aVar.hfA = (TextView) inflate2.findViewById(e.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.hfu.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hfu.getLayoutMode().onModeChanged(view);
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
            bVar.hfD.setText(str);
            al.c(bVar.hfE, BitmapHelper.getSmallGradeResourceIdNew(dVar.bAA()));
            bVar.hfF.setText(dVar.bAB() + "/" + dVar.bAC());
            bVar.hfN.clearAnimation();
            if (dVar.aaN()) {
                bVar.hfC.setVisibility(0);
                bVar.hfM.setVisibility(8);
                bVar.hfH.setVisibility(0);
                bVar.hfI.setVisibility(8);
                bVar.hfH.setText(String.format(this.hfu.getPageContext().getString(e.j.signallforum_days), Integer.valueOf(dVar.bAz())));
                if (dVar.bAG()) {
                    bVar.hfF.setText(this.hfu.getPageContext().getString(e.j.signallforum_uplevel));
                    bVar.hfN.setVisibility(8);
                } else {
                    bVar.hfF.setText(dVar.bAB() + "/" + dVar.bAC());
                    bVar.hfN.setVisibility(0);
                }
                int bAF = dVar.bAF();
                if (bAF > 0) {
                    bVar.hfN.setVisibility(0);
                    bVar.hfN.setText("+" + bAF);
                } else {
                    bVar.hfN.setVisibility(8);
                }
            } else if (dVar.bAD()) {
                bVar.hfC.setVisibility(0);
                bVar.hfM.setVisibility(8);
                bVar.hfN.setVisibility(8);
                bVar.hfH.setVisibility(8);
                bVar.hfI.setVisibility(0);
                if (dVar.bAE()) {
                    bVar.hfJ.setVisibility(4);
                    bVar.hfK.setVisibility(0);
                    bVar.hfL.setText(e.j.signallforum_resigning);
                } else {
                    bVar.hfJ.setVisibility(0);
                    bVar.hfK.setVisibility(4);
                    bVar.hfL.setText(e.j.signallforum_resign);
                }
                bVar.hfI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.bAE()) {
                            bVar.hfJ.setVisibility(4);
                            bVar.hfK.setVisibility(0);
                            bVar.hfL.setText(e.j.signallforum_resigning);
                            dVar.nk(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.hfu);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.hfv.put(str2, signSingleModel);
                            }
                            signSingleModel.cG(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.hfH.setVisibility(8);
                bVar.hfI.setVisibility(8);
                bVar.hfN.setVisibility(8);
                bVar.hfC.setVisibility(0);
                bVar.hfM.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.hfB.setTag(avatar);
            bVar.hfB.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.cOG) {
            return axO();
        }
        int itemViewType = getItemViewType(i);
        View vl = view == null ? vl(itemViewType) : view;
        if (itemViewType == 1) {
            if (vl.getTag() != null && (vl.getTag() instanceof a)) {
                view2 = vl;
                aVar = (a) vl.getTag();
            } else {
                View vl2 = vl(itemViewType);
                view2 = vl2;
                aVar = (a) vl2.getTag();
            }
            this.hfu.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.hfu.getLayoutMode().onModeChanged(view2.findViewById(e.g.sign_all_forum_tip));
            aVar.hfz.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            o(aVar.hfA, i);
            return view2;
        }
        if (vl.getTag() == null || !(vl.getTag() instanceof b)) {
            vl = vl(itemViewType);
        }
        a(vl, viewGroup, i);
        return vl;
    }

    private void o(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.hfa == null ? 7 : this.hfa.getLevel();
        if (this.dpB == null || this.dpB.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.dpB.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.bAA() >= level) {
                        if (next.aaN()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aaN()) {
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
            format = String.format(this.hfu.getPageContext().getString(e.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.hfu.getPageContext().getString(e.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View axO() {
        View inflate = LayoutInflater.from(this.hfu.getPageContext().getPageActivity()).inflate(e.h.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.hfu.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(e.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.H(e.j.sign_all_forum_nodata_tip, e.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hfu.getLayoutMode().setNightMode(skinType == 1);
        this.hfu.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.hfu.getPageContext(), skinType);
        a2.setVisibility(0);
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
    /* loaded from: classes3.dex */
    public class b {
        public BarImageView hfB;
        public LinearLayout hfC;
        public TextView hfD;
        public ImageView hfE;
        public TextView hfF;
        public FrameLayout hfG;
        public TextView hfH;
        public RelativeLayout hfI;
        public ImageView hfJ;
        public ProgressBar hfK;
        public TextView hfL;
        public TextView hfM;
        public TextView hfN;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView hfA;
        public TextView hfz;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.hfv.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void cF(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.hfu.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.hfv.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.dpB.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.dpB.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.ni(z);
                dVar.nj(!z);
                dVar.nk(false);
                if (z) {
                    dVar.vi(signData.count_sign_num);
                    dVar.vk(signData.sign_bonus_point);
                    dVar.vh(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> bAq = this.hfa.bAq();
                    if (bAq.contains(dVar)) {
                        bAq.remove(dVar);
                        this.hfa.bAp().add(dVar);
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

    public void bAM() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.hfv.entrySet()) {
                    entry.getValue().bBg();
                }
                this.hfv.clear();
            }
        }
    }
}
