package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.c;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.h, af {
    private OriginalThreadInfo ajH;
    private SkinInfo aja;
    private String ajd;
    @Deprecated
    private String authorId;
    private TbRichTextVoiceInfo aye;
    private String bimg_url;
    private SmallTailInfo fLZ;
    private String fsq;
    private boolean ftD;
    public int gOA;
    public AlaLiveInfoCoreData gOF;
    private ArrayList<PostData> gOe;
    private com.baidu.tbadk.data.c gOl;
    private com.baidu.tbadk.data.f gOm;
    private h gOp;
    private ay gOq;
    public boolean gOs;
    private com.baidu.tbadk.widget.richText.f gOt;
    private String gOu;
    private String gOv;
    private TPointPost gOw;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId gNT = BdUniqueId.gen();
    public static final BdUniqueId gNU = BdUniqueId.gen();
    public static final BdUniqueId ajb = BdUniqueId.gen();
    public static final BdUniqueId gNV = BdUniqueId.gen();
    public static final BdUniqueId ahA = BdUniqueId.gen();
    public static final BdUniqueId gNW = BdUniqueId.gen();
    public static final BdUniqueId gNX = BdUniqueId.gen();
    public static final BdUniqueId gNY = BdUniqueId.gen();
    public static boolean gNZ = false;
    private int gOa = 0;
    private boolean gOf = false;
    private ArrayList<PostData> gOg = null;
    private TbRichText gOh = null;
    private boolean gOk = false;
    private boolean gOn = false;
    private boolean gOo = false;
    public boolean gOr = false;
    public int aiA = 0;
    private boolean gOx = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean gOy = false;
    public boolean gOz = false;
    public boolean gOB = false;
    public boolean gOC = true;
    public boolean gOD = false;
    public boolean gOE = false;
    private boolean gOG = false;
    private int gOH = 0;
    private boolean gOI = true;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData aib = new MetaData();
    private ArrayList<k> gOb = new ArrayList<>();
    private ArrayList<k> gOc = new ArrayList<>();
    private int gOd = 0;
    private int aiK = 0;
    private PraiseData aio = new PraiseData();
    private am gOi = new am();
    private c gOj = new c();
    private ArrayList<com.baidu.tbadk.data.c> aiX = new ArrayList<>();

    public PostData() {
        this.gOe = null;
        this.gOA = 0;
        this.gOe = new ArrayList<>();
        this.gOA = 0;
    }

    public void js(boolean z) {
        this.ftD = z;
    }

    public boolean bvX() {
        return this.ftD;
    }

    public ArrayList<PostData> bvY() {
        return this.gOg;
    }

    public void bvZ() {
        this.gOg.clear();
        this.gOg = null;
        this.gOf = false;
    }

    public void o(PostData postData) {
        if (postData != null) {
            if (this.gOg == null) {
                this.gOg = new ArrayList<>();
                if (w.y(this.gOe) > 2) {
                    this.gOg.addAll(w.a(this.gOe, 0, 2));
                } else {
                    this.gOg.addAll(this.gOe);
                }
            }
            this.gOg.add(postData);
        }
    }

    public void p(PostData postData) {
        if (postData != null && this.gOe != null) {
            this.gOe.add(postData);
            bwd();
        }
    }

    public void tK(String str) {
        if (this.gOg != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gOg.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gOg.remove(next);
                    return;
                }
            }
        }
    }

    public void mq(boolean z) {
        this.gOI = z;
    }

    public boolean bwa() {
        return this.gOI;
    }

    public void mr(boolean z) {
        this.gOf = z;
    }

    public boolean bwb() {
        return this.gOf;
    }

    public ArrayList<PostData> bwc() {
        return this.gOe;
    }

    public void bwd() {
        this.gOd++;
    }

    public void bwe() {
        this.gOd--;
    }

    public void tI(int i) {
        this.gOd = i;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String aZg() {
        return this.fsq;
    }

    public int bwf() {
        return this.floor_num;
    }

    public void tJ(int i) {
        this.floor_num = i;
    }

    public boolean bwg() {
        return this.gOo;
    }

    public void ms(boolean z) {
        this.gOo = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ap.w(j);
    }

    public MetaData vk() {
        return this.aib;
    }

    public void a(MetaData metaData) {
        this.aib = metaData;
    }

    public void a(PraiseData praiseData) {
        this.aio = praiseData;
    }

    public TbRichText bwh() {
        return this.gOh;
    }

    public void c(TbRichText tbRichText) {
        this.gOh = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bfZ() {
        return this.fLZ;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.fLZ = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bwi() {
        return this.gOm;
    }

    public SkinInfo vF() {
        return this.aja;
    }

    public void mt(boolean z) {
        this.gOG = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.gOh != null && this.gOh.Nx() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.aib != null && this.aib.getIs_bawu() == 1) {
                    if (this.ftD) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.aib.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.aib.getBawu_type())) {
                        str = " 小吧主";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = vk().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.ih().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.ih().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((C02371) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.nc()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.gOh.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.c(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.aib.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.aib.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.aib == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.aib.getName_show() + str + "：");
                str2 = this.aib.getUserName();
                str3 = this.aib.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.aib.getSealPrefix())) {
                Bitmap cT = com.baidu.tbadk.core.util.am.cT(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cT);
                if (cT != null) {
                    bitmapDrawable.setBounds(0, 0, cT.getWidth(), cT.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.aib.getSealPrefix().length() + 1;
                spannableString.setSpan(jVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.aib != null && this.aib.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b S = S(z, this.aib != null && this.aib.getIs_bawu() == 1);
                if (S != null) {
                    if (this.aib != null) {
                        spannableString.setSpan(S, sb2.length() + this.aib.getName_show().length() + 1, str.length() + sb2.length() + this.aib.getName_show().length(), 17);
                    } else {
                        spannableString.setSpan(S, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> Nx = this.gOh.Nx();
            if (Nx != null && Nx.size() > 0) {
                TbRichTextData tbRichTextData2 = Nx.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.NE() != null) {
                    if (this.gOG) {
                        int indexOf = tbRichTextData2.NE().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.NE().delete(0, indexOf + 1);
                        }
                        this.gOG = false;
                    }
                    tbRichTextData2.fZ(sb.length());
                    tbRichTextData2.NE().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Nx.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Nx.get(i4) == null || Nx.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo NF = Nx.get(i4).NF();
                        Nx.remove(i4);
                        tbRichTextVoiceInfo = NF;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fZ(sb.length());
                tbRichTextData.append(spannableString);
                Nx.add(0, tbRichTextData);
            }
        }
    }

    private com.baidu.tbadk.core.view.b S(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        return new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.f(context, d.e.tbds1), com.baidu.adp.lib.util.l.f(context, d.e.tbds4), this.ftD ? d.C0140d.cp_link_tip_a_alpha50 : d.C0140d.cp_cont_j_alpha50, com.baidu.adp.lib.util.l.f(context, d.e.tbds30), this.ftD ? d.C0140d.cp_link_tip_a : d.C0140d.cp_cont_j, com.baidu.adp.lib.util.l.f(context, d.e.tbds12), com.baidu.adp.lib.util.l.f(context, d.e.tbds42));
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap nb;
        if (aVar == null || (nb = aVar.nb()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(nb);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36));
        return bitmapDrawable;
    }

    public int bwj() {
        return this.gOd;
    }

    public void ch(Context context) {
        int type;
        int i;
        int i2;
        if (this.gOb != null) {
            int i3 = -1;
            int size = this.gOc.size();
            if (size > 0) {
                try {
                    i3 = this.gOc.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.gOb.size()) {
                k kVar = this.gOb.get(i4);
                if (k.bK(i5, kVar.getType())) {
                    this.gOc.get(size - 1).b(kVar.cg(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.gOc.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.cg(context));
                        this.gOc.add(kVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void ci(Context context) {
        try {
            if (this.gOh != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.gOh.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.gOc == null || this.gOc.size() == 0) {
                ch(context);
            }
            ArrayList<k> arrayList = this.gOc;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bvQ() != null) {
                            sb.append((CharSequence) next.bvQ());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.j.voice_str));
                    } else if (next.getType() == 2) {
                        String gC = TbFaceManager.IP().gC(next.getText());
                        if (gC != null) {
                            sb.append("[");
                            sb.append(gC);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ap.isEmpty(next.bvP())) {
                        sb.append("[").append(next.bvP()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.floor_num = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = ap.w(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.gOn = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aib = metaData;
                }
                if ((this.aib.getUserId() == null || this.aib.getUserId().length() <= 0 || this.aib.getUserId().equals("0")) && metaData2 != null) {
                    this.aib = metaData2;
                }
                this.gOh = TbRichTextView.a(context, subPostList.content, z);
                if (this.gOh != null) {
                    this.gOh.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = ap.w(this.time);
                this.fsq = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aib = metaData;
                }
                this.gOy = post.need_log.intValue() == 1;
                this.gOz = post.img_num_abtest.intValue() == 1;
                this.gOq = new ay();
                this.gOq.parserProtobuf(post.from_forum);
                if (this.aib.getUserId() == null || this.aib.getUserId().length() <= 0 || this.aib.getUserId().equals("0")) {
                    this.aib.parserProtobuf(post.author);
                }
                if (this.aib != null && context != null) {
                    this.gOu = this.aib.getUserName() + context.getResources().getString(d.j.somebodys_portrait);
                    this.gOv = String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(this.aib.getLevel_id()));
                }
                this.gOk = post.is_ntitle.intValue() == 1;
                this.gOd = post.sub_post_number.intValue();
                this.gOp = new h(post.tpoint_post);
                this.gOh = TbRichTextView.a(context, post.content, true);
                if (this.gOh != null) {
                    this.gOh.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.gOh.fY(this.floor_num);
                    if (this.aib != null) {
                        this.gOh.setAuthorId(this.aib.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.gOn = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.js(this.ftD);
                            postData.a(subPostList, context);
                            this.gOe.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.gOj.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.gOl = new com.baidu.tbadk.data.c();
                    this.gOl.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.gOm = new com.baidu.tbadk.data.f();
                    this.gOm.a(post.lbs_info);
                }
                this.aiK = post.storecount.intValue();
                this.gOi.a(post.present);
                this.aio.setUserMap(this.userMap);
                this.aio.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.fLZ = new SmallTailInfo();
                    this.fLZ.id = post.signature.signature_id.intValue();
                    this.fLZ.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.fLZ.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.fLZ.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.fLZ.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.aiX.add(cVar);
                    }
                }
                this.aja = post.skin_info;
                this.ajd = post.lego_card;
                this.gOw = post.tpoint_post;
                if (post.agree != null) {
                    this.gOx = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                } else {
                    this.gOx = false;
                }
                this.gOE = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.ajH = new OriginalThreadInfo();
                    this.ajH.parser(post.origin_thread_info);
                } else {
                    this.ajH = null;
                }
                this.gOH = post.is_fold.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int fKj;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(com.baidu.tbadk.core.util.am.getColor(this.fKj));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> gOO;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.gOO = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(com.baidu.tbadk.core.util.am.getColor(d.C0140d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.gOO != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.gOO.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String cj(Context context) {
        ArrayList<TbRichTextData> Nx;
        if (this.gOh == null || (Nx = this.gOh.Nx()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Nx.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.NE().toString());
            } else if (next.getType() == 17) {
                String str = next.NI().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(d.j.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(d.j.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(d.j.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String bwk() {
        ArrayList<TbRichTextData> Nx;
        String str;
        if (this.gOh == null || (Nx = this.gOh.Nx()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = Nx.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.NE().toString());
                } else if (next.getType() == 17) {
                    if (next.NI() != null && next.NI().mGifInfo != null && (str = next.NI().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo bwl() {
        ArrayList<TbRichTextData> Nx;
        if (this.gOh != null && (Nx = this.gOh.Nx()) != null) {
            Iterator<TbRichTextData> it = Nx.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.ND().getWidth();
                    preLoadImageInfo.height = next.ND().getHeight();
                    preLoadImageInfo.imgUrl = next.ND().NS();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.NJ().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.NJ().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.NJ().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bwm() {
        j bvI;
        PreLoadImageInfo bwl = bwl();
        if (bwl != null && !StringUtils.isNull(bwl.imgUrl)) {
            return bwl.imgUrl;
        }
        if (this.gOp != null && (bvI = this.gOp.bvI()) != null && !StringUtils.isNull(bvI.bvN())) {
            return bvI.bvN();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.af
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Nx;
        if (this.gOh == null || (Nx = this.gOh.Nx()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Nx.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.ND().getWidth();
                preLoadImageInfo.height = next.ND().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.ND().NX()) {
                    preLoadImageInfo.imgUrl = next.ND().NT();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.ND().NS();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.NI() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.NI().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.NI().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.NI();
                preLoadImageInfo2.procType = 20;
                arrayList.add(preLoadImageInfo2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bimg_url;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.procType = 19;
            arrayList.add(preLoadImageInfo3);
        }
        if (this.aib == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.aib.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.gOa == 52) {
            return gNX;
        }
        if (this.gOa == 1) {
            return ajb;
        }
        if (this.gOa == 36) {
            return gNV;
        }
        if (this.gOa == 40 || this.gOa == 50) {
            return ahA;
        }
        if (this.gOa == 41) {
            return gNW;
        }
        if (this.gOa == 53) {
            return gNY;
        }
        if (bwf() == 1) {
            return gNT;
        }
        return gNU;
    }

    public void setPostType(int i) {
        this.gOa = i;
    }

    public am bwn() {
        return this.gOi;
    }

    public void a(am amVar) {
        this.gOi = amVar;
    }

    public h bwo() {
        return this.gOp;
    }

    public com.baidu.tbadk.widget.richText.f NH() {
        if (this.gOt != null) {
            return this.gOt;
        }
        if (this.gOh != null && w.y(this.gOh.Nx()) > 0) {
            Iterator<TbRichTextData> it = this.gOh.Nx().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.gOt = next.NH();
                    return this.gOt;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo NF() {
        if (this.aye != null) {
            return this.aye;
        }
        if (this.gOh != null && w.y(this.gOh.Nx()) > 0) {
            Iterator<TbRichTextData> it = this.gOh.Nx().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aye = next.NF();
                    return this.aye;
                }
            }
        }
        return null;
    }

    public String bwp() {
        return this.gOu;
    }

    public String wc() {
        return this.ajd;
    }

    public void wf() {
        if (this.aiA == 0) {
            this.aiA = 1;
        }
    }

    public long bwq() {
        return this.agreeNum;
    }

    public void cS(long j) {
        this.agreeNum = j;
    }

    public boolean bwr() {
        return this.hasAgree;
    }

    public void mu(boolean z) {
        this.hasAgree = z;
    }

    public OriginalThreadInfo bws() {
        return this.ajH;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.ajH = originalThreadInfo;
    }

    public int bwt() {
        return this.gOH;
    }
}
