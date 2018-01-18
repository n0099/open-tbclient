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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.m;
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
public class PostData implements com.baidu.adp.widget.ListView.i, ae {
    private OriginalThreadInfo aOZ;
    private SkinInfo aOs;
    private String aOv;
    @Deprecated
    private String authorId;
    private TbRichTextVoiceInfo bcn;
    private String bimg_url;
    private String fDd;
    private SmallTailInfo fXv;
    private com.baidu.tbadk.data.f gYA;
    private h gYD;
    private ay gYE;
    public boolean gYG;
    private com.baidu.tbadk.widget.richText.f gYH;
    private String gYI;
    private String gYJ;
    private TPointPost gYK;
    public int gYO;
    public AlaLiveInfoCoreData gYT;
    private ArrayList<PostData> gYs;
    private com.baidu.tbadk.data.c gYz;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId gYf = BdUniqueId.gen();
    public static final BdUniqueId gYg = BdUniqueId.gen();
    public static final BdUniqueId gYh = BdUniqueId.gen();
    public static final BdUniqueId aOt = BdUniqueId.gen();
    public static final BdUniqueId gYi = BdUniqueId.gen();
    public static final BdUniqueId aNb = BdUniqueId.gen();
    public static final BdUniqueId gYj = BdUniqueId.gen();
    public static final BdUniqueId gYk = BdUniqueId.gen();
    public static final BdUniqueId gYl = BdUniqueId.gen();
    public static final BdUniqueId gYm = BdUniqueId.gen();
    public static boolean gYn = false;
    private int gYo = 0;
    private boolean gYt = false;
    private ArrayList<PostData> gYu = null;
    private TbRichText gYv = null;
    private boolean gYy = false;
    private boolean gYB = false;
    private boolean gYC = false;
    public boolean gYF = false;
    public int aNS = 0;
    private boolean gYL = false;
    private long dFr = 0;
    private boolean dFt = false;
    public boolean gYM = false;
    public boolean gYN = false;
    public boolean gYP = false;
    public boolean gYQ = true;
    public boolean gYR = false;
    public boolean gYS = false;
    private boolean gYU = false;
    private int gYV = 0;
    private boolean gYW = true;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData aNu = new MetaData();
    private ArrayList<k> gYp = new ArrayList<>();
    private ArrayList<k> gYq = new ArrayList<>();
    private int gYr = 0;
    private int aOc = 0;
    private PraiseData aNG = new PraiseData();
    private am gYw = new am();
    private c gYx = new c();
    private ArrayList<com.baidu.tbadk.data.c> aOq = new ArrayList<>();

    public PostData() {
        this.gYs = null;
        this.gYO = 0;
        this.gYs = new ArrayList<>();
        this.gYO = 0;
    }

    public ArrayList<PostData> bvz() {
        return this.gYu;
    }

    public void bvA() {
        this.gYu.clear();
        this.gYu = null;
        this.gYt = false;
    }

    public void s(PostData postData) {
        if (postData != null) {
            if (this.gYu == null) {
                this.gYu = new ArrayList<>();
                if (v.D(this.gYs) > 2) {
                    this.gYu.addAll(v.b(this.gYs, 0, 2));
                } else {
                    this.gYu.addAll(this.gYs);
                }
            }
            this.gYu.add(postData);
        }
    }

    public void t(PostData postData) {
        if (postData != null && this.gYs != null) {
            this.gYs.add(postData);
            bvF();
        }
    }

    public void sx(String str) {
        if (this.gYu != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gYu.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gYu.remove(next);
                    return;
                }
            }
        }
    }

    public void mw(boolean z) {
        this.gYW = z;
    }

    public boolean bvB() {
        return this.gYW;
    }

    public void mx(boolean z) {
        this.gYt = z;
    }

    public boolean bvC() {
        return this.gYt;
    }

    public c bvD() {
        return this.gYx;
    }

    public ArrayList<PostData> bvE() {
        return this.gYs;
    }

    public void bvF() {
        this.gYr++;
    }

    public void bvG() {
        this.gYr--;
    }

    public void vK(int i) {
        this.gYr = i;
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

    public String aYt() {
        return this.fDd;
    }

    public int bvH() {
        return this.floor_num;
    }

    public void vL(int i) {
        this.floor_num = i;
    }

    public boolean bvI() {
        return this.gYC;
    }

    public void my(boolean z) {
        this.gYC = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = com.baidu.tbadk.core.util.am.z(j);
    }

    public String bvJ() {
        return this.date;
    }

    public MetaData yS() {
        return this.aNu;
    }

    public void a(MetaData metaData) {
        this.aNu = metaData;
    }

    public void a(PraiseData praiseData) {
        this.aNG = praiseData;
    }

    public TbRichText bvK() {
        return this.gYv;
    }

    public void c(TbRichText tbRichText) {
        this.gYv = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bfv() {
        return this.fXv;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.fXv = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bvL() {
        return this.gYA;
    }

    public SkinInfo zo() {
        return this.aOs;
    }

    public void mz(boolean z) {
        this.gYU = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.gYv != null && this.gYv.QB() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else if (this.aNu != null && this.aNu.getIs_bawu() == 1 && "manager".equals(this.aNu.getBawu_type())) {
                str = " 吧主";
            } else if (this.aNu == null || this.aNu.getIs_bawu() != 1 || !"assist".equals(this.aNu.getBawu_type())) {
                str = "";
            } else {
                str = " 小吧";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = yS().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.nl().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.nl().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str4, int i) {
                                        super.onLoaded((C01551) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.sj()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.gYv.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.k(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.aNu.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.aNu.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.aNu == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.aNu.getName_show() + str + "：");
                str2 = this.aNu.getUserName();
                str3 = this.aNu.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.aNu.getSealPrefix())) {
                Bitmap fO = aj.fO(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(fO);
                if (fO != null) {
                    bitmapDrawable.setBounds(0, 0, fO.getWidth(), fO.getHeight());
                }
                m mVar = new m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.aNu.getSealPrefix().length() + 1;
                spannableString.setSpan(mVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.aNu != null && this.aNu.getIs_bawu() == 1))) {
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0107d.cp_link_tip_a);
                if (this.aNu != null) {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.aNu.getName_show().length() + 1, str.length() + sb2.length() + this.aNu.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> QB = this.gYv.QB();
            if (QB != null && QB.size() > 0) {
                TbRichTextData tbRichTextData2 = QB.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.QI() != null) {
                    if (this.gYU) {
                        int indexOf = tbRichTextData2.QI().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.QI().delete(0, indexOf + 1);
                        }
                        this.gYU = false;
                    }
                    tbRichTextData2.iX(sb.length());
                    tbRichTextData2.QI().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= QB.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (QB.get(i4) == null || QB.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo QJ = QB.get(i4).QJ();
                        QB.remove(i4);
                        tbRichTextVoiceInfo = QJ;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.iX(sb.length());
                tbRichTextData.append(spannableString);
                QB.add(0, tbRichTextData);
            }
        }
    }

    protected Drawable h(com.baidu.adp.widget.a.a aVar) {
        Bitmap si;
        if (aVar == null || (si = aVar.si()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(si);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36));
        return bitmapDrawable;
    }

    public int bvM() {
        return this.gYr;
    }

    public void cj(Context context) {
        int type;
        int i;
        int i2;
        if (this.gYp != null) {
            int i3 = -1;
            int size = this.gYq.size();
            if (size > 0) {
                try {
                    i3 = this.gYq.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.gYp.size()) {
                k kVar = this.gYp.get(i4);
                if (k.cM(i5, kVar.getType())) {
                    this.gYq.get(size - 1).b(kVar.ci(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.gYq.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.ci(context));
                        this.gYq.add(kVar2);
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

    public void ck(Context context) {
        try {
            if (this.gYv != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.gYv.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.gYq == null || this.gYq.size() == 0) {
                cj(context);
            }
            ArrayList<k> arrayList = this.gYq;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bvs() != null) {
                            sb.append((CharSequence) next.bvs());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.j.voice_str));
                    } else if (next.getType() == 2) {
                        String fV = TbFaceManager.LO().fV(next.getText());
                        if (fV != null) {
                            sb.append("[");
                            sb.append(fV);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !com.baidu.tbadk.core.util.am.isEmpty(next.bvr())) {
                        sb.append("[").append(next.bvr()).append("]");
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
                this.date = com.baidu.tbadk.core.util.am.z(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.gYB = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aNu = metaData;
                }
                if ((this.aNu.getUserId() == null || this.aNu.getUserId().length() <= 0 || this.aNu.getUserId().equals("0")) && metaData2 != null) {
                    this.aNu = metaData2;
                }
                this.gYv = TbRichTextView.a(context, subPostList.content, z);
                if (this.gYv != null) {
                    this.gYv.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.date = com.baidu.tbadk.core.util.am.z(this.time);
                this.fDd = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aNu = metaData;
                }
                this.gYM = post.need_log.intValue() == 1;
                this.gYN = post.img_num_abtest.intValue() == 1;
                this.gYE = new ay();
                this.gYE.parserProtobuf(post.from_forum);
                if (this.aNu.getUserId() == null || this.aNu.getUserId().length() <= 0 || this.aNu.getUserId().equals("0")) {
                    this.aNu.parserProtobuf(post.author);
                }
                if (this.aNu != null && context != null) {
                    this.gYI = this.aNu.getUserName() + context.getResources().getString(d.j.somebodys_portrait);
                    this.gYJ = String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(this.aNu.getLevel_id()));
                }
                this.gYy = post.is_ntitle.intValue() == 1;
                this.gYr = post.sub_post_number.intValue();
                this.gYD = new h(post.tpoint_post);
                this.gYv = TbRichTextView.a(context, post.content, true);
                if (this.gYv != null) {
                    this.gYv.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.gYv.iW(this.floor_num);
                    if (this.aNu != null) {
                        this.gYv.setAuthorId(this.aNu.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.gYB = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.gYs.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.gYx.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.gYz = new com.baidu.tbadk.data.c();
                    this.gYz.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.gYA = new com.baidu.tbadk.data.f();
                    this.gYA.a(post.lbs_info);
                }
                this.aOc = post.storecount.intValue();
                this.gYw.a(post.present);
                this.aNG.setUserMap(this.userMap);
                this.aNG.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.fXv = new SmallTailInfo();
                    this.fXv.id = post.signature.signature_id.intValue();
                    this.fXv.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.fXv.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.fXv.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.fXv.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.aOq.add(cVar);
                    }
                }
                this.aOs = post.skin_info;
                this.aOv = post.lego_card;
                this.gYK = post.tpoint_post;
                if (post.agree != null) {
                    this.gYL = true;
                    this.dFt = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.dFr = post.agree.agree_num.longValue();
                    } else {
                        this.dFr = 0L;
                    }
                } else {
                    this.gYL = false;
                }
                this.gYS = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.aOZ = new OriginalThreadInfo();
                    this.aOZ.parser(post.origin_thread_info);
                } else {
                    this.aOZ = null;
                }
                this.gYV = post.is_fold.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int fVL;

        public CustomForegroundColorSpan(int i) {
            super(aj.getColor(i));
            this.fVL = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(this.fVL));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> gZc;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.gZc = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.C0107d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.gZc != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.gZc.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String cl(Context context) {
        ArrayList<TbRichTextData> QB;
        if (this.gYv == null || (QB = this.gYv.QB()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = QB.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.QI().toString());
            } else if (next.getType() == 17) {
                String str = next.QM().mGifInfo.mSharpText;
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

    public String bvN() {
        ArrayList<TbRichTextData> QB;
        String str;
        if (this.gYv == null || (QB = this.gYv.QB()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = QB.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.QI().toString());
                } else if (next.getType() == 17) {
                    if (next.QM() != null && next.QM().mGifInfo != null && (str = next.QM().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo bvO() {
        ArrayList<TbRichTextData> QB;
        if (this.gYv != null && (QB = this.gYv.QB()) != null) {
            Iterator<TbRichTextData> it = QB.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.QH().getWidth();
                    preLoadImageInfo.height = next.QH().getHeight();
                    preLoadImageInfo.imgUrl = next.QH().QV();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                }
            }
            return null;
        }
        return null;
    }

    public String bvP() {
        j bvk;
        PreLoadImageInfo bvO = bvO();
        if (bvO != null && !StringUtils.isNull(bvO.imgUrl)) {
            return bvO.imgUrl;
        }
        if (this.gYD != null && (bvk = this.gYD.bvk()) != null && !StringUtils.isNull(bvk.bvp())) {
            return bvk.bvp();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> QB;
        if (this.gYv == null || (QB = this.gYv.QB()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = QB.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.QH().getWidth();
                preLoadImageInfo.height = next.QH().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.QH().Ra()) {
                    preLoadImageInfo.imgUrl = next.QH().QW();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.QH().QV();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.QM() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.QM().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.QM().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.QM();
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
        if (this.aNu == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.aNu.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.gYo == 52) {
            return gYl;
        }
        if (this.gYo == 2) {
            return gYh;
        }
        if (this.gYo == 1) {
            return aOt;
        }
        if (this.gYo == 36) {
            return gYi;
        }
        if (this.gYo == 40 || this.gYo == 50) {
            return aNb;
        }
        if (this.gYo == 41) {
            return gYj;
        }
        if (this.gYo == 53) {
            return gYm;
        }
        if (bvH() == 1) {
            return gYf;
        }
        return gYg;
    }

    public void setPostType(int i) {
        this.gYo = i;
    }

    public am bvQ() {
        return this.gYw;
    }

    public void a(am amVar) {
        this.gYw = amVar;
    }

    public h bvR() {
        return this.gYD;
    }

    public com.baidu.tbadk.widget.richText.f QL() {
        if (this.gYH != null) {
            return this.gYH;
        }
        if (this.gYv != null && v.D(this.gYv.QB()) > 0) {
            Iterator<TbRichTextData> it = this.gYv.QB().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.gYH = next.QL();
                    return this.gYH;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo QJ() {
        if (this.bcn != null) {
            return this.bcn;
        }
        if (this.gYv != null && v.D(this.gYv.QB()) > 0) {
            Iterator<TbRichTextData> it = this.gYv.QB().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.bcn = next.QJ();
                    return this.bcn;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.c> bvS() {
        return this.aOq;
    }

    public String bvT() {
        return this.gYI;
    }

    public String bvU() {
        return this.gYJ;
    }

    public String zL() {
        return this.aOv;
    }

    public void zO() {
        if (this.aNS == 0) {
            this.aNS = 1;
        }
    }

    public long bvV() {
        return this.dFr;
    }

    public void cP(long j) {
        this.dFr = j;
    }

    public boolean bvW() {
        return this.dFt;
    }

    public void mA(boolean z) {
        this.dFt = z;
    }

    public OriginalThreadInfo bvX() {
        return this.aOZ;
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        this.aOZ = originalThreadInfo;
    }

    public int bvY() {
        return this.gYV;
    }
}
