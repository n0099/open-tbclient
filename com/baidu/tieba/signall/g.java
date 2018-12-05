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
    private c hbW;
    private SignAllForumActivity hcq;
    private boolean isDestory;
    private ArrayList<d> dmJ = new ArrayList<>();
    private HashMap<String, SignSingleModel> hcr = new HashMap<>();
    private boolean dul = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.hcq = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.hbW = cVar;
            this.dmJ = cVar.bzy();
            if (this.dmJ.size() == 0) {
                this.dul = false;
            } else {
                this.dul = true;
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
        if (this.dul) {
            return this.dmJ.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dmJ.size() > i) {
            return this.dmJ.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View uY(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.hcq.getPageContext().getPageActivity()).inflate(e.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.hcx = (BarImageView) inflate.findViewById(e.g.signallforum_item_avatar);
            bVar.hcx.setIsRound(false);
            bVar.hcx.setGifIconSupport(false);
            bVar.hcz = (TextView) inflate.findViewById(e.g.signallforum_item_name);
            bVar.hcA = (ImageView) inflate.findViewById(e.g.signallforum_item_level);
            bVar.hcB = (TextView) inflate.findViewById(e.g.signallforum_item_exp);
            bVar.hcC = (FrameLayout) inflate.findViewById(e.g.signallforum_item_res_container);
            bVar.hcD = (TextView) inflate.findViewById(e.g.signallforum_item_days);
            bVar.hcE = (RelativeLayout) inflate.findViewById(e.g.signallforum_item_resign_container);
            bVar.hcF = (ImageView) inflate.findViewById(e.g.signallforum_item_resign_icon);
            bVar.hcG = (ProgressBar) inflate.findViewById(e.g.signallforum_item_resign_progress);
            bVar.hcH = (TextView) inflate.findViewById(e.g.signallforum_item_resign_text);
            bVar.hcI = (TextView) inflate.findViewById(e.g.signallforum_item_error);
            bVar.hcy = (LinearLayout) inflate.findViewById(e.g.signallforum_item_level_container);
            bVar.hcJ = (TextView) inflate.findViewById(e.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.hcq.getPageContext().getPageActivity()).inflate(e.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.hcv = (TextView) inflate2.findViewById(e.g.signallforum_head_title);
        aVar.hcw = (TextView) inflate2.findViewById(e.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.hcq.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hcq.getLayoutMode().onModeChanged(view);
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
            bVar.hcz.setText(str);
            al.c(bVar.hcA, BitmapHelper.getSmallGradeResourceIdNew(dVar.bzL()));
            bVar.hcB.setText(dVar.bzM() + "/" + dVar.bzN());
            bVar.hcJ.clearAnimation();
            if (dVar.aaL()) {
                bVar.hcy.setVisibility(0);
                bVar.hcI.setVisibility(8);
                bVar.hcD.setVisibility(0);
                bVar.hcE.setVisibility(8);
                bVar.hcD.setText(String.format(this.hcq.getPageContext().getString(e.j.signallforum_days), Integer.valueOf(dVar.bzK())));
                if (dVar.bzR()) {
                    bVar.hcB.setText(this.hcq.getPageContext().getString(e.j.signallforum_uplevel));
                    bVar.hcJ.setVisibility(8);
                } else {
                    bVar.hcB.setText(dVar.bzM() + "/" + dVar.bzN());
                    bVar.hcJ.setVisibility(0);
                }
                int bzQ = dVar.bzQ();
                if (bzQ > 0) {
                    bVar.hcJ.setVisibility(0);
                    bVar.hcJ.setText("+" + bzQ);
                } else {
                    bVar.hcJ.setVisibility(8);
                }
            } else if (dVar.bzO()) {
                bVar.hcy.setVisibility(0);
                bVar.hcI.setVisibility(8);
                bVar.hcJ.setVisibility(8);
                bVar.hcD.setVisibility(8);
                bVar.hcE.setVisibility(0);
                if (dVar.bzP()) {
                    bVar.hcF.setVisibility(4);
                    bVar.hcG.setVisibility(0);
                    bVar.hcH.setText(e.j.signallforum_resigning);
                } else {
                    bVar.hcF.setVisibility(0);
                    bVar.hcG.setVisibility(4);
                    bVar.hcH.setText(e.j.signallforum_resign);
                }
                bVar.hcE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.bzP()) {
                            bVar.hcF.setVisibility(4);
                            bVar.hcG.setVisibility(0);
                            bVar.hcH.setText(e.j.signallforum_resigning);
                            dVar.nh(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.hcq);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.hcr.put(str2, signSingleModel);
                            }
                            signSingleModel.cG(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.hcD.setVisibility(8);
                bVar.hcE.setVisibility(8);
                bVar.hcJ.setVisibility(8);
                bVar.hcy.setVisibility(0);
                bVar.hcI.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.hcx.setTag(avatar);
            bVar.hcx.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.dul) {
            return awZ();
        }
        int itemViewType = getItemViewType(i);
        View uY = view == null ? uY(itemViewType) : view;
        if (itemViewType == 1) {
            if (uY.getTag() != null && (uY.getTag() instanceof a)) {
                view2 = uY;
                aVar = (a) uY.getTag();
            } else {
                View uY2 = uY(itemViewType);
                view2 = uY2;
                aVar = (a) uY2.getTag();
            }
            this.hcq.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.hcq.getLayoutMode().onModeChanged(view2.findViewById(e.g.sign_all_forum_tip));
            aVar.hcv.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            o(aVar.hcw, i);
            return view2;
        }
        if (uY.getTag() == null || !(uY.getTag() instanceof b)) {
            uY = uY(itemViewType);
        }
        a(uY, viewGroup, i);
        return uY;
    }

    private void o(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.hbW == null ? 7 : this.hbW.getLevel();
        if (this.dmJ == null || this.dmJ.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.dmJ.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.bzL() >= level) {
                        if (next.aaL()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aaL()) {
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
            format = String.format(this.hcq.getPageContext().getString(e.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.hcq.getPageContext().getString(e.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View awZ() {
        View inflate = LayoutInflater.from(this.hcq.getPageContext().getPageActivity()).inflate(e.h.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.hcq.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(e.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.H(e.j.sign_all_forum_nodata_tip, e.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hcq.getLayoutMode().setNightMode(skinType == 1);
        this.hcq.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.hcq.getPageContext(), skinType);
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
        public ImageView hcA;
        public TextView hcB;
        public FrameLayout hcC;
        public TextView hcD;
        public RelativeLayout hcE;
        public ImageView hcF;
        public ProgressBar hcG;
        public TextView hcH;
        public TextView hcI;
        public TextView hcJ;
        public BarImageView hcx;
        public LinearLayout hcy;
        public TextView hcz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView hcv;
        public TextView hcw;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.hcr.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void cF(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.hcq.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.hcr.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.dmJ.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.dmJ.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.nf(z);
                dVar.ng(!z);
                dVar.nh(false);
                if (z) {
                    dVar.uV(signData.count_sign_num);
                    dVar.uX(signData.sign_bonus_point);
                    dVar.uU(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> bzB = this.hbW.bzB();
                    if (bzB.contains(dVar)) {
                        bzB.remove(dVar);
                        this.hbW.bzA().add(dVar);
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

    public void bzX() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.hcr.entrySet()) {
                    entry.getValue().bAr();
                }
                this.hcr.clear();
            }
        }
    }
}
