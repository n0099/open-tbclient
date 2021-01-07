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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes8.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private boolean niF;
    private SignAllForumActivity niQ;
    private c nis;
    private ArrayList<d> iES = new ArrayList<>();
    private HashMap<String, SignSingleModel> niR = new HashMap<>();
    private boolean iUF = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.niQ = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.nis = cVar;
            this.iES = cVar.dMd();
            if (this.iES.size() == 0) {
                this.iUF = false;
            } else {
                this.iUF = true;
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
        if (this.iUF) {
            return this.iES.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iES.size() > i) {
            return this.iES.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Kz(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.niQ.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.niX = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.niX.setIsRound(false);
            bVar.niX.setGifIconSupport(false);
            bVar.niZ = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.gkp = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.nja = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.njb = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.njc = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.njd = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.nje = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.njf = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.njg = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.njh = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.niY = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.nji = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.niQ.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.niV = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.niW = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void b(View view, View view2, int i) {
        String str;
        this.niQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.niQ.getLayoutMode().onModeChanged(view);
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
            bVar.niZ.setText(str);
            ao.setImageResource(bVar.gkp, BitmapHelper.getSmallGradeResourceIdNew(dVar.bNV()));
            bVar.nja.setText(dVar.dMq() + "/" + dVar.dMr());
            bVar.nji.clearAnimation();
            if (dVar.bVv()) {
                bVar.niY.setVisibility(0);
                bVar.njh.setVisibility(8);
                bVar.njc.setVisibility(0);
                bVar.njd.setVisibility(8);
                bVar.njc.setText(String.format(this.niQ.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.dMp())));
                if (dVar.dMv()) {
                    bVar.nja.setText(this.niQ.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.nji.setVisibility(8);
                } else {
                    bVar.nja.setText(dVar.dMq() + "/" + dVar.dMr());
                    bVar.nji.setVisibility(0);
                }
                int dMu = dVar.dMu();
                if (dMu > 0) {
                    bVar.nji.setVisibility(0);
                    bVar.nji.setText("+" + dMu);
                } else {
                    bVar.nji.setVisibility(8);
                }
            } else if (dVar.dMs()) {
                bVar.niY.setVisibility(0);
                bVar.njh.setVisibility(8);
                bVar.nji.setVisibility(8);
                bVar.njc.setVisibility(8);
                bVar.njd.setVisibility(0);
                if (dVar.dMt()) {
                    bVar.nje.setVisibility(4);
                    bVar.njf.setVisibility(0);
                    bVar.njg.setText(R.string.signallforum_resigning);
                } else {
                    bVar.nje.setVisibility(0);
                    bVar.njf.setVisibility(4);
                    bVar.njg.setText(R.string.signallforum_resign);
                }
                bVar.njd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.dMt()) {
                            bVar.nje.setVisibility(4);
                            bVar.njf.setVisibility(0);
                            bVar.njg.setText(R.string.signallforum_resigning);
                            dVar.xP(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.niQ);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.niR.put(str2, signSingleModel);
                            }
                            signSingleModel.gm(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.njc.setVisibility(8);
                bVar.njd.setVisibility(8);
                bVar.nji.setVisibility(8);
                bVar.niY.setVisibility(0);
                bVar.njh.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.niX.setTag(avatar);
            bVar.niX.setPlaceHolder(1);
            bVar.niX.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (!this.iUF) {
            return cBQ();
        }
        int itemViewType = getItemViewType(i);
        View Kz = view == null ? Kz(itemViewType) : view;
        if (itemViewType == 1) {
            if (Kz.getTag() != null && (Kz.getTag() instanceof a)) {
                aVar = (a) Kz.getTag();
            } else {
                Kz = Kz(itemViewType);
                aVar = (a) Kz.getTag();
            }
            this.niQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.niQ.getLayoutMode().onModeChanged(Kz.findViewById(R.id.sign_all_forum_tip));
            aVar.niV.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            j(aVar.niW, i);
            return Kz;
        }
        if (Kz.getTag() == null || !(Kz.getTag() instanceof b)) {
            Kz = Kz(itemViewType);
        }
        b(Kz, viewGroup, i);
        return Kz;
    }

    private void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.nis == null ? 7 : this.nis.getLevel();
        if (this.iES == null || this.iES.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.iES.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.bNV() >= level) {
                        if (next.bVv()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bVv()) {
                        i3++;
                    } else {
                        i2++;
                    }
                    i2 = i2;
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.niQ.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.niQ.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View cBQ() {
        View inflate = LayoutInflater.from(this.niQ.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.niQ.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.niQ.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dY(null, this.niQ.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.niQ.getLayoutMode().setNightMode(skinType == 1);
        this.niQ.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.niQ.getPageContext(), skinType);
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
    /* loaded from: classes8.dex */
    public class b {
        public ImageView gkp;
        public BarImageView niX;
        public LinearLayout niY;
        public TextView niZ;
        public TextView nja;
        public FrameLayout njb;
        public TextView njc;
        public RelativeLayout njd;
        public ImageView nje;
        public ProgressBar njf;
        public TextView njg;
        public TextView njh;
        public TextView nji;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a {
        public TextView niV;
        public TextView niW;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.niR.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void gl(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.niQ.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.niR.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.iES.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.iES.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.xN(z);
                dVar.xO(!z);
                dVar.xP(false);
                if (z) {
                    dVar.Kx(signData.count_sign_num);
                    dVar.Ky(signData.sign_bonus_point);
                    dVar.Kw(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> dMg = this.nis.dMg();
                    if (dMg.contains(dVar)) {
                        dMg.remove(dVar);
                        this.nis.dMf().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.niF) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void dMB() {
        this.niF = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.niR.entrySet()) {
                    entry.getValue().dMU();
                }
                this.niR.clear();
            }
        }
    }
}
