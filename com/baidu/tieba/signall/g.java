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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c gRR;
    private SignAllForumActivity gSk;
    private boolean isDestory;
    private ArrayList<d> doe = new ArrayList<>();
    private HashMap<String, SignSingleModel> gSl = new HashMap<>();
    private boolean dvb = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.gSk = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.gRR = cVar;
            this.doe = cVar.btd();
            if (this.doe.size() == 0) {
                this.dvb = false;
            } else {
                this.dvb = true;
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
        if (this.dvb) {
            return this.doe.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.doe.size() > i) {
            return this.doe.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View vq(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.gSk.getPageContext().getPageActivity()).inflate(d.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.gSr = (BarImageView) inflate.findViewById(d.g.signallforum_item_avatar);
            bVar.gSr.setIsRound(false);
            bVar.gSr.setGifIconSupport(false);
            bVar.gSt = (TextView) inflate.findViewById(d.g.signallforum_item_name);
            bVar.gSu = (ImageView) inflate.findViewById(d.g.signallforum_item_level);
            bVar.gSv = (TextView) inflate.findViewById(d.g.signallforum_item_exp);
            bVar.gSw = (FrameLayout) inflate.findViewById(d.g.signallforum_item_res_container);
            bVar.gSx = (TextView) inflate.findViewById(d.g.signallforum_item_days);
            bVar.gSy = (RelativeLayout) inflate.findViewById(d.g.signallforum_item_resign_container);
            bVar.gSz = (ImageView) inflate.findViewById(d.g.signallforum_item_resign_icon);
            bVar.gSA = (ProgressBar) inflate.findViewById(d.g.signallforum_item_resign_progress);
            bVar.gSB = (TextView) inflate.findViewById(d.g.signallforum_item_resign_text);
            bVar.gSC = (TextView) inflate.findViewById(d.g.signallforum_item_error);
            bVar.gSs = (LinearLayout) inflate.findViewById(d.g.signallforum_item_level_container);
            bVar.gSD = (TextView) inflate.findViewById(d.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.gSk.getPageContext().getPageActivity()).inflate(d.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.gSp = (TextView) inflate2.findViewById(d.g.signallforum_head_title);
        aVar.gSq = (TextView) inflate2.findViewById(d.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void d(View view, View view2, int i) {
        String str;
        this.gSk.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gSk.getLayoutMode().aM(view);
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
            bVar.gSt.setText(str);
            aj.c(bVar.gSu, BitmapHelper.getSmallGradeResourceIdNew(dVar.btq()));
            bVar.gSv.setText(dVar.btr() + "/" + dVar.bts());
            bVar.gSD.clearAnimation();
            if (dVar.XA()) {
                bVar.gSs.setVisibility(0);
                bVar.gSC.setVisibility(8);
                bVar.gSx.setVisibility(0);
                bVar.gSy.setVisibility(8);
                bVar.gSx.setText(String.format(this.gSk.getPageContext().getString(d.j.signallforum_days), Integer.valueOf(dVar.btp())));
                if (dVar.btw()) {
                    bVar.gSv.setText(this.gSk.getPageContext().getString(d.j.signallforum_uplevel));
                    bVar.gSD.setVisibility(8);
                } else {
                    bVar.gSv.setText(dVar.btr() + "/" + dVar.bts());
                    bVar.gSD.setVisibility(0);
                }
                int btv = dVar.btv();
                if (btv > 0) {
                    bVar.gSD.setVisibility(0);
                    bVar.gSD.setText("+" + btv);
                } else {
                    bVar.gSD.setVisibility(8);
                }
            } else if (dVar.btt()) {
                String errorMsg = dVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.gSs.setVisibility(8);
                    bVar.gSC.setVisibility(0);
                    bVar.gSD.setVisibility(8);
                    bVar.gSC.setText(errorMsg);
                } else {
                    bVar.gSs.setVisibility(0);
                    bVar.gSC.setVisibility(8);
                    bVar.gSD.setVisibility(8);
                }
                bVar.gSx.setVisibility(8);
                bVar.gSy.setVisibility(0);
                if (dVar.btu()) {
                    bVar.gSz.setVisibility(4);
                    bVar.gSA.setVisibility(0);
                    bVar.gSB.setText(d.j.signallforum_resigning);
                } else {
                    bVar.gSz.setVisibility(0);
                    bVar.gSA.setVisibility(4);
                    bVar.gSB.setText(d.j.signallforum_resign);
                }
                bVar.gSy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.btu()) {
                            bVar.gSz.setVisibility(4);
                            bVar.gSA.setVisibility(0);
                            bVar.gSB.setText(d.j.signallforum_resigning);
                            dVar.mw(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.gSk);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.gSl.put(str2, signSingleModel);
                            }
                            signSingleModel.bY(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.gSx.setVisibility(8);
                bVar.gSy.setVisibility(8);
                bVar.gSD.setVisibility(8);
                bVar.gSs.setVisibility(0);
                bVar.gSC.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.gSr.setTag(avatar);
            bVar.gSr.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.dvb) {
            return asp();
        }
        int itemViewType = getItemViewType(i);
        View vq = view == null ? vq(itemViewType) : view;
        if (itemViewType == 1) {
            if (vq.getTag() != null && (vq.getTag() instanceof a)) {
                view2 = vq;
                aVar = (a) vq.getTag();
            } else {
                View vq2 = vq(itemViewType);
                view2 = vq2;
                aVar = (a) vq2.getTag();
            }
            this.gSk.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gSk.getLayoutMode().aM(view2.findViewById(d.g.sign_all_forum_tip));
            aVar.gSp.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            p(aVar.gSq, i);
            return view2;
        }
        if (vq.getTag() == null || !(vq.getTag() instanceof b)) {
            vq = vq(itemViewType);
        }
        d(vq, viewGroup, i);
        return vq;
    }

    private void p(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.gRR == null ? 7 : this.gRR.getLevel();
        if (this.doe == null || this.doe.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.doe.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.btq() >= level) {
                        if (next.XA()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.XA()) {
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
            format = String.format(this.gSk.getPageContext().getString(d.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.gSk.getPageContext().getString(d.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View asp() {
        View inflate = LayoutInflater.from(this.gSk.getPageContext().getPageActivity()).inflate(d.h.sign_all_forum_nodata_item, (ViewGroup) null);
        com.baidu.tbadk.core.view.h a2 = NoDataViewFactory.a(this.gSk.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(d.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.aC(d.j.sign_all_forum_nodata_tip, d.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gSk.getLayoutMode().aQ(skinType == 1);
        this.gSk.getLayoutMode().aM(inflate);
        a2.onChangeSkinType(this.gSk.getPageContext(), skinType);
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
        public ProgressBar gSA;
        public TextView gSB;
        public TextView gSC;
        public TextView gSD;
        public BarImageView gSr;
        public LinearLayout gSs;
        public TextView gSt;
        public ImageView gSu;
        public TextView gSv;
        public FrameLayout gSw;
        public TextView gSx;
        public RelativeLayout gSy;
        public ImageView gSz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView gSp;
        public TextView gSq;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.gSl.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void bX(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.l.showToast(this.gSk.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.gSl.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.doe.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.doe.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.mu(z);
                dVar.mv(!z);
                dVar.mw(false);
                if (z) {
                    dVar.vn(signData.count_sign_num);
                    dVar.vp(signData.sign_bonus_point);
                    dVar.vm(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> btg = this.gRR.btg();
                    if (btg.contains(dVar)) {
                        btg.remove(dVar);
                        this.gRR.btf().add(dVar);
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

    public void btB() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.gSl.entrySet()) {
                    entry.getValue().btW();
                }
                this.gSl.clear();
            }
        }
    }
}
