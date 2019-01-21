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
    private c hgf;
    private SignAllForumActivity hgz;
    private boolean isDestory;
    private ArrayList<d> dqo = new ArrayList<>();
    private HashMap<String, SignSingleModel> hgA = new HashMap<>();
    private boolean cPs = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.hgz = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.hgf = cVar;
            this.dqo = cVar.bAW();
            if (this.dqo.size() == 0) {
                this.cPs = false;
            } else {
                this.cPs = true;
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
        if (this.cPs) {
            return this.dqo.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dqo.size() > i) {
            return this.dqo.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View vo(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.hgz.getPageContext().getPageActivity()).inflate(e.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.hgG = (BarImageView) inflate.findViewById(e.g.signallforum_item_avatar);
            bVar.hgG.setIsRound(false);
            bVar.hgG.setGifIconSupport(false);
            bVar.hgI = (TextView) inflate.findViewById(e.g.signallforum_item_name);
            bVar.hgJ = (ImageView) inflate.findViewById(e.g.signallforum_item_level);
            bVar.hgK = (TextView) inflate.findViewById(e.g.signallforum_item_exp);
            bVar.hgL = (FrameLayout) inflate.findViewById(e.g.signallforum_item_res_container);
            bVar.hgM = (TextView) inflate.findViewById(e.g.signallforum_item_days);
            bVar.hgN = (RelativeLayout) inflate.findViewById(e.g.signallforum_item_resign_container);
            bVar.hgO = (ImageView) inflate.findViewById(e.g.signallforum_item_resign_icon);
            bVar.hgP = (ProgressBar) inflate.findViewById(e.g.signallforum_item_resign_progress);
            bVar.hgQ = (TextView) inflate.findViewById(e.g.signallforum_item_resign_text);
            bVar.hgR = (TextView) inflate.findViewById(e.g.signallforum_item_error);
            bVar.hgH = (LinearLayout) inflate.findViewById(e.g.signallforum_item_level_container);
            bVar.hgS = (TextView) inflate.findViewById(e.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.hgz.getPageContext().getPageActivity()).inflate(e.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.hgE = (TextView) inflate2.findViewById(e.g.signallforum_head_title);
        aVar.hgF = (TextView) inflate2.findViewById(e.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.hgz.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.hgz.getLayoutMode().onModeChanged(view);
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
            bVar.hgI.setText(str);
            al.c(bVar.hgJ, BitmapHelper.getSmallGradeResourceIdNew(dVar.bBj()));
            bVar.hgK.setText(dVar.bBk() + "/" + dVar.bBl());
            bVar.hgS.clearAnimation();
            if (dVar.abk()) {
                bVar.hgH.setVisibility(0);
                bVar.hgR.setVisibility(8);
                bVar.hgM.setVisibility(0);
                bVar.hgN.setVisibility(8);
                bVar.hgM.setText(String.format(this.hgz.getPageContext().getString(e.j.signallforum_days), Integer.valueOf(dVar.bBi())));
                if (dVar.bBp()) {
                    bVar.hgK.setText(this.hgz.getPageContext().getString(e.j.signallforum_uplevel));
                    bVar.hgS.setVisibility(8);
                } else {
                    bVar.hgK.setText(dVar.bBk() + "/" + dVar.bBl());
                    bVar.hgS.setVisibility(0);
                }
                int bBo = dVar.bBo();
                if (bBo > 0) {
                    bVar.hgS.setVisibility(0);
                    bVar.hgS.setText("+" + bBo);
                } else {
                    bVar.hgS.setVisibility(8);
                }
            } else if (dVar.bBm()) {
                bVar.hgH.setVisibility(0);
                bVar.hgR.setVisibility(8);
                bVar.hgS.setVisibility(8);
                bVar.hgM.setVisibility(8);
                bVar.hgN.setVisibility(0);
                if (dVar.bBn()) {
                    bVar.hgO.setVisibility(4);
                    bVar.hgP.setVisibility(0);
                    bVar.hgQ.setText(e.j.signallforum_resigning);
                } else {
                    bVar.hgO.setVisibility(0);
                    bVar.hgP.setVisibility(4);
                    bVar.hgQ.setText(e.j.signallforum_resign);
                }
                bVar.hgN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.bBn()) {
                            bVar.hgO.setVisibility(4);
                            bVar.hgP.setVisibility(0);
                            bVar.hgQ.setText(e.j.signallforum_resigning);
                            dVar.nl(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.hgz);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.hgA.put(str2, signSingleModel);
                            }
                            signSingleModel.cH(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.hgM.setVisibility(8);
                bVar.hgN.setVisibility(8);
                bVar.hgS.setVisibility(8);
                bVar.hgH.setVisibility(0);
                bVar.hgR.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.hgG.setTag(avatar);
            bVar.hgG.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.cPs) {
            return ayl();
        }
        int itemViewType = getItemViewType(i);
        View vo = view == null ? vo(itemViewType) : view;
        if (itemViewType == 1) {
            if (vo.getTag() != null && (vo.getTag() instanceof a)) {
                view2 = vo;
                aVar = (a) vo.getTag();
            } else {
                View vo2 = vo(itemViewType);
                view2 = vo2;
                aVar = (a) vo2.getTag();
            }
            this.hgz.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.hgz.getLayoutMode().onModeChanged(view2.findViewById(e.g.sign_all_forum_tip));
            aVar.hgE.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            o(aVar.hgF, i);
            return view2;
        }
        if (vo.getTag() == null || !(vo.getTag() instanceof b)) {
            vo = vo(itemViewType);
        }
        a(vo, viewGroup, i);
        return vo;
    }

    private void o(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.hgf == null ? 7 : this.hgf.getLevel();
        if (this.dqo == null || this.dqo.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.dqo.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.bBj() >= level) {
                        if (next.abk()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.abk()) {
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
            format = String.format(this.hgz.getPageContext().getString(e.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.hgz.getPageContext().getString(e.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View ayl() {
        View inflate = LayoutInflater.from(this.hgz.getPageContext().getPageActivity()).inflate(e.h.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.hgz.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(e.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.H(e.j.sign_all_forum_nodata_tip, e.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hgz.getLayoutMode().setNightMode(skinType == 1);
        this.hgz.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.hgz.getPageContext(), skinType);
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
        public BarImageView hgG;
        public LinearLayout hgH;
        public TextView hgI;
        public ImageView hgJ;
        public TextView hgK;
        public FrameLayout hgL;
        public TextView hgM;
        public RelativeLayout hgN;
        public ImageView hgO;
        public ProgressBar hgP;
        public TextView hgQ;
        public TextView hgR;
        public TextView hgS;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView hgE;
        public TextView hgF;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.hgA.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void cG(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.hgz.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.hgA.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.dqo.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.dqo.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.nj(z);
                dVar.nk(!z);
                dVar.nl(false);
                if (z) {
                    dVar.vl(signData.count_sign_num);
                    dVar.vn(signData.sign_bonus_point);
                    dVar.vk(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> bAZ = this.hgf.bAZ();
                    if (bAZ.contains(dVar)) {
                        bAZ.remove(dVar);
                        this.hgf.bAY().add(dVar);
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

    public void bBv() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.hgA.entrySet()) {
                    entry.getValue().bBP();
                }
                this.hgA.clear();
            }
        }
    }
}
