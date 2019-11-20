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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private SignAllForumActivity iZE;
    private c iZk;
    private boolean isDestory;
    private ArrayList<d> eYf = new ArrayList<>();
    private HashMap<String, SignSingleModel> iZF = new HashMap<>();
    private boolean fkg = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.iZE = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.iZk = cVar;
            this.eYf = cVar.clB();
            if (this.eYf.size() == 0) {
                this.fkg = false;
            } else {
                this.fkg = true;
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
        if (this.fkg) {
            return this.eYf.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eYf.size() > i) {
            return this.eYf.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View zA(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.iZE.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.iZL = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.iZL.setIsRound(false);
            bVar.iZL.setGifIconSupport(false);
            bVar.iZN = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.iZO = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.iZP = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.iZQ = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.iZR = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.iZS = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.iZT = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.iZU = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.iZV = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.iZW = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.iZM = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.iZX = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.iZE.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.iZJ = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.iZK = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.iZE.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iZE.getLayoutMode().onModeChanged(view);
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
            bVar.iZN.setText(str);
            am.setImageResource(bVar.iZO, BitmapHelper.getSmallGradeResourceIdNew(dVar.clO()));
            bVar.iZP.setText(dVar.clP() + "/" + dVar.clQ());
            bVar.iZX.clearAnimation();
            if (dVar.aJV()) {
                bVar.iZM.setVisibility(0);
                bVar.iZW.setVisibility(8);
                bVar.iZR.setVisibility(0);
                bVar.iZS.setVisibility(8);
                bVar.iZR.setText(String.format(this.iZE.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.clN())));
                if (dVar.clU()) {
                    bVar.iZP.setText(this.iZE.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.iZX.setVisibility(8);
                } else {
                    bVar.iZP.setText(dVar.clP() + "/" + dVar.clQ());
                    bVar.iZX.setVisibility(0);
                }
                int clT = dVar.clT();
                if (clT > 0) {
                    bVar.iZX.setVisibility(0);
                    bVar.iZX.setText("+" + clT);
                } else {
                    bVar.iZX.setVisibility(8);
                }
            } else if (dVar.clR()) {
                bVar.iZM.setVisibility(0);
                bVar.iZW.setVisibility(8);
                bVar.iZX.setVisibility(8);
                bVar.iZR.setVisibility(8);
                bVar.iZS.setVisibility(0);
                if (dVar.clS()) {
                    bVar.iZT.setVisibility(4);
                    bVar.iZU.setVisibility(0);
                    bVar.iZV.setText(R.string.signallforum_resigning);
                } else {
                    bVar.iZT.setVisibility(0);
                    bVar.iZU.setVisibility(4);
                    bVar.iZV.setText(R.string.signallforum_resign);
                }
                bVar.iZS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.clS()) {
                            bVar.iZT.setVisibility(4);
                            bVar.iZU.setVisibility(0);
                            bVar.iZV.setText(R.string.signallforum_resigning);
                            dVar.qD(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.iZE);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.iZF.put(str2, signSingleModel);
                            }
                            signSingleModel.dT(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.iZR.setVisibility(8);
                bVar.iZS.setVisibility(8);
                bVar.iZX.setVisibility(8);
                bVar.iZM.setVisibility(0);
                bVar.iZW.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.iZL.setTag(avatar);
            bVar.iZL.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.fkg) {
            return bgT();
        }
        int itemViewType = getItemViewType(i);
        View zA = view == null ? zA(itemViewType) : view;
        if (itemViewType == 1) {
            if (zA.getTag() != null && (zA.getTag() instanceof a)) {
                view2 = zA;
                aVar = (a) zA.getTag();
            } else {
                View zA2 = zA(itemViewType);
                view2 = zA2;
                aVar = (a) zA2.getTag();
            }
            this.iZE.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.iZE.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.iZJ.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            h(aVar.iZK, i);
            return view2;
        }
        if (zA.getTag() == null || !(zA.getTag() instanceof b)) {
            zA = zA(itemViewType);
        }
        a(zA, viewGroup, i);
        return zA;
    }

    private void h(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.iZk == null ? 7 : this.iZk.getLevel();
        if (this.eYf == null || this.eYf.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.eYf.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.clO() >= level) {
                        if (next.aJV()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aJV()) {
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
            format = String.format(this.iZE.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.iZE.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bgT() {
        View inflate = LayoutInflater.from(this.iZE.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.iZE.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.ai(R.string.sign_all_forum_nodata_tip, R.string.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iZE.getLayoutMode().setNightMode(skinType == 1);
        this.iZE.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.iZE.getPageContext(), skinType);
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
        public BarImageView iZL;
        public LinearLayout iZM;
        public TextView iZN;
        public ImageView iZO;
        public TextView iZP;
        public FrameLayout iZQ;
        public TextView iZR;
        public RelativeLayout iZS;
        public ImageView iZT;
        public ProgressBar iZU;
        public TextView iZV;
        public TextView iZW;
        public TextView iZX;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a {
        public TextView iZJ;
        public TextView iZK;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.iZF.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void dS(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.iZE.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.iZF.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.eYf.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.eYf.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.qB(z);
                dVar.qC(!z);
                dVar.qD(false);
                if (z) {
                    dVar.zx(signData.count_sign_num);
                    dVar.zz(signData.sign_bonus_point);
                    dVar.zw(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> clE = this.iZk.clE();
                    if (clE.contains(dVar)) {
                        clE.remove(dVar);
                        this.iZk.clD().add(dVar);
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

    public void cma() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.iZF.entrySet()) {
                    entry.getValue().cmt();
                }
                this.iZF.clear();
            }
        }
    }
}
