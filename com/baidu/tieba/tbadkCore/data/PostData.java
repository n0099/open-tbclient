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
    private SkinInfo aOv;
    private String aOy;
    private OriginalThreadInfo aPc;
    @Deprecated
    private String authorId;
    private TbRichTextVoiceInfo bcv;
    private String bimg_url;
    private String fDy;
    private SmallTailInfo fXQ;
    private ArrayList<PostData> gYM;
    private com.baidu.tbadk.data.c gYT;
    private com.baidu.tbadk.data.f gYU;
    private h gYX;
    private ay gYY;
    public boolean gZa;
    private com.baidu.tbadk.widget.richText.f gZb;
    private String gZc;
    private String gZd;
    private TPointPost gZe;
    public int gZi;
    public AlaLiveInfoCoreData gZn;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId gYz = BdUniqueId.gen();
    public static final BdUniqueId gYA = BdUniqueId.gen();
    public static final BdUniqueId gYB = BdUniqueId.gen();
    public static final BdUniqueId aOw = BdUniqueId.gen();
    public static final BdUniqueId gYC = BdUniqueId.gen();
    public static final BdUniqueId aNe = BdUniqueId.gen();
    public static final BdUniqueId gYD = BdUniqueId.gen();
    public static final BdUniqueId gYE = BdUniqueId.gen();
    public static final BdUniqueId gYF = BdUniqueId.gen();
    public static final BdUniqueId gYG = BdUniqueId.gen();
    public static boolean gYH = false;
    private int gYI = 0;
    private boolean gYN = false;
    private ArrayList<PostData> gYO = null;
    private TbRichText gYP = null;
    private boolean gYS = false;
    private boolean gYV = false;
    private boolean gYW = false;
    public boolean gYZ = false;
    public int aNV = 0;
    private boolean gZf = false;
    private long dFM = 0;
    private boolean dFO = false;
    public boolean gZg = false;
    public boolean gZh = false;
    public boolean gZj = false;
    public boolean gZk = true;
    public boolean gZl = false;
    public boolean gZm = false;
    private boolean gZo = false;
    private int gZp = 0;
    private boolean gZq = true;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData aNx = new MetaData();
    private ArrayList<k> gYJ = new ArrayList<>();
    private ArrayList<k> gYK = new ArrayList<>();
    private int gYL = 0;
    private int aOf = 0;
    private PraiseData aNJ = new PraiseData();
    private am gYQ = new am();
    private c gYR = new c();
    private ArrayList<com.baidu.tbadk.data.c> aOt = new ArrayList<>();

    public PostData() {
        this.gYM = null;
        this.gZi = 0;
        this.gYM = new ArrayList<>();
        this.gZi = 0;
    }

    public ArrayList<PostData> bvB() {
        return this.gYO;
    }

    public void bvC() {
        this.gYO.clear();
        this.gYO = null;
        this.gYN = false;
    }

    public void s(PostData postData) {
        if (postData != null) {
            if (this.gYO == null) {
                this.gYO = new ArrayList<>();
                if (v.D(this.gYM) > 2) {
                    this.gYO.addAll(v.b(this.gYM, 0, 2));
                } else {
                    this.gYO.addAll(this.gYM);
                }
            }
            this.gYO.add(postData);
        }
    }

    public void t(PostData postData) {
        if (postData != null && this.gYM != null) {
            this.gYM.add(postData);
            bvH();
        }
    }

    public void sF(String str) {
        if (this.gYO != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gYO.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gYO.remove(next);
                    return;
                }
            }
        }
    }

    public void mz(boolean z) {
        this.gZq = z;
    }

    public boolean bvD() {
        return this.gZq;
    }

    public void mA(boolean z) {
        this.gYN = z;
    }

    public boolean bvE() {
        return this.gYN;
    }

    public c bvF() {
        return this.gYR;
    }

    public ArrayList<PostData> bvG() {
        return this.gYM;
    }

    public void bvH() {
        this.gYL++;
    }

    public void bvI() {
        this.gYL--;
    }

    public void vK(int i) {
        this.gYL = i;
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

    public String aYy() {
        return this.fDy;
    }

    public int bvJ() {
        return this.floor_num;
    }

    public void vL(int i) {
        this.floor_num = i;
    }

    public boolean bvK() {
        return this.gYW;
    }

    public void mB(boolean z) {
        this.gYW = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = com.baidu.tbadk.core.util.am.z(j);
    }

    public String bvL() {
        return this.date;
    }

    public MetaData yT() {
        return this.aNx;
    }

    public void a(MetaData metaData) {
        this.aNx = metaData;
    }

    public void a(PraiseData praiseData) {
        this.aNJ = praiseData;
    }

    public TbRichText bvM() {
        return this.gYP;
    }

    public void c(TbRichText tbRichText) {
        this.gYP = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bfA() {
        return this.fXQ;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.fXQ = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bvN() {
        return this.gYU;
    }

    public SkinInfo zp() {
        return this.aOv;
    }

    public void mC(boolean z) {
        this.gZo = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.gYP != null && this.gYP.QD() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else if (this.aNx != null && this.aNx.getIs_bawu() == 1 && "manager".equals(this.aNx.getBawu_type())) {
                str = " 吧主";
            } else if (this.aNx == null || this.aNx.getIs_bawu() != 1 || !"assist".equals(this.aNx.getBawu_type())) {
                str = "";
            } else {
                str = " 小吧";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = yT().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.nm().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.nm().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str4, int i) {
                                        super.onLoaded((C01561) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.sk()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.gYP.isChanged = true;
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
            if (!StringUtils.isNull(this.aNx.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.aNx.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.aNx == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.aNx.getName_show() + str + "：");
                str2 = this.aNx.getUserName();
                str3 = this.aNx.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.aNx.getSealPrefix())) {
                Bitmap fO = aj.fO(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(fO);
                if (fO != null) {
                    bitmapDrawable.setBounds(0, 0, fO.getWidth(), fO.getHeight());
                }
                m mVar = new m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.aNx.getSealPrefix().length() + 1;
                spannableString.setSpan(mVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.aNx != null && this.aNx.getIs_bawu() == 1))) {
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0108d.cp_link_tip_a);
                if (this.aNx != null) {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.aNx.getName_show().length() + 1, str.length() + sb2.length() + this.aNx.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> QD = this.gYP.QD();
            if (QD != null && QD.size() > 0) {
                TbRichTextData tbRichTextData2 = QD.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.QK() != null) {
                    if (this.gZo) {
                        int indexOf = tbRichTextData2.QK().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.QK().delete(0, indexOf + 1);
                        }
                        this.gZo = false;
                    }
                    tbRichTextData2.iX(sb.length());
                    tbRichTextData2.QK().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= QD.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (QD.get(i4) == null || QD.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo QL = QD.get(i4).QL();
                        QD.remove(i4);
                        tbRichTextVoiceInfo = QL;
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
                QD.add(0, tbRichTextData);
            }
        }
    }

    protected Drawable h(com.baidu.adp.widget.a.a aVar) {
        Bitmap sj;
        if (aVar == null || (sj = aVar.sj()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(sj);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36));
        return bitmapDrawable;
    }

    public int bvO() {
        return this.gYL;
    }

    public void cg(Context context) {
        int type;
        int i;
        int i2;
        if (this.gYJ != null) {
            int i3 = -1;
            int size = this.gYK.size();
            if (size > 0) {
                try {
                    i3 = this.gYK.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.gYJ.size()) {
                k kVar = this.gYJ.get(i4);
                if (k.cM(i5, kVar.getType())) {
                    this.gYK.get(size - 1).b(kVar.cf(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.gYK.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.cf(context));
                        this.gYK.add(kVar2);
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

    public void ch(Context context) {
        try {
            if (this.gYP != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.gYP.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.gYK == null || this.gYK.size() == 0) {
                cg(context);
            }
            ArrayList<k> arrayList = this.gYK;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bvu() != null) {
                            sb.append((CharSequence) next.bvu());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.j.voice_str));
                    } else if (next.getType() == 2) {
                        String gd = TbFaceManager.LQ().gd(next.getText());
                        if (gd != null) {
                            sb.append("[");
                            sb.append(gd);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !com.baidu.tbadk.core.util.am.isEmpty(next.bvt())) {
                        sb.append("[").append(next.bvt()).append("]");
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
                this.gYV = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aNx = metaData;
                }
                if ((this.aNx.getUserId() == null || this.aNx.getUserId().length() <= 0 || this.aNx.getUserId().equals("0")) && metaData2 != null) {
                    this.aNx = metaData2;
                }
                this.gYP = TbRichTextView.a(context, subPostList.content, z);
                if (this.gYP != null) {
                    this.gYP.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.fDy = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aNx = metaData;
                }
                this.gZg = post.need_log.intValue() == 1;
                this.gZh = post.img_num_abtest.intValue() == 1;
                this.gYY = new ay();
                this.gYY.parserProtobuf(post.from_forum);
                if (this.aNx.getUserId() == null || this.aNx.getUserId().length() <= 0 || this.aNx.getUserId().equals("0")) {
                    this.aNx.parserProtobuf(post.author);
                }
                if (this.aNx != null && context != null) {
                    this.gZc = this.aNx.getUserName() + context.getResources().getString(d.j.somebodys_portrait);
                    this.gZd = String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(this.aNx.getLevel_id()));
                }
                this.gYS = post.is_ntitle.intValue() == 1;
                this.gYL = post.sub_post_number.intValue();
                this.gYX = new h(post.tpoint_post);
                this.gYP = TbRichTextView.a(context, post.content, true);
                if (this.gYP != null) {
                    this.gYP.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.gYP.iW(this.floor_num);
                    if (this.aNx != null) {
                        this.gYP.setAuthorId(this.aNx.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.gYV = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.gYM.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.gYR.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.gYT = new com.baidu.tbadk.data.c();
                    this.gYT.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.gYU = new com.baidu.tbadk.data.f();
                    this.gYU.a(post.lbs_info);
                }
                this.aOf = post.storecount.intValue();
                this.gYQ.a(post.present);
                this.aNJ.setUserMap(this.userMap);
                this.aNJ.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.fXQ = new SmallTailInfo();
                    this.fXQ.id = post.signature.signature_id.intValue();
                    this.fXQ.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.fXQ.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.fXQ.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.fXQ.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.aOt.add(cVar);
                    }
                }
                this.aOv = post.skin_info;
                this.aOy = post.lego_card;
                this.gZe = post.tpoint_post;
                if (post.agree != null) {
                    this.gZf = true;
                    this.dFO = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.dFM = post.agree.agree_num.longValue();
                    } else {
                        this.dFM = 0L;
                    }
                } else {
                    this.gZf = false;
                }
                this.gZm = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.aPc = new OriginalThreadInfo();
                    this.aPc.parser(post.origin_thread_info);
                } else {
                    this.aPc = null;
                }
                this.gZp = post.is_fold.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int fWg;

        public CustomForegroundColorSpan(int i) {
            super(aj.getColor(i));
            this.fWg = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(this.fWg));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> gZw;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.gZw = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.C0108d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.gZw != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.gZw.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String ci(Context context) {
        ArrayList<TbRichTextData> QD;
        if (this.gYP == null || (QD = this.gYP.QD()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = QD.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.QK().toString());
            } else if (next.getType() == 17) {
                String str = next.QO().mGifInfo.mSharpText;
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

    public String bvP() {
        ArrayList<TbRichTextData> QD;
        String str;
        if (this.gYP == null || (QD = this.gYP.QD()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = QD.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.QK().toString());
                } else if (next.getType() == 17) {
                    if (next.QO() != null && next.QO().mGifInfo != null && (str = next.QO().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo bvQ() {
        ArrayList<TbRichTextData> QD;
        if (this.gYP != null && (QD = this.gYP.QD()) != null) {
            Iterator<TbRichTextData> it = QD.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.QJ().getWidth();
                    preLoadImageInfo.height = next.QJ().getHeight();
                    preLoadImageInfo.imgUrl = next.QJ().QX();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                }
            }
            return null;
        }
        return null;
    }

    public String bvR() {
        j bvm;
        PreLoadImageInfo bvQ = bvQ();
        if (bvQ != null && !StringUtils.isNull(bvQ.imgUrl)) {
            return bvQ.imgUrl;
        }
        if (this.gYX != null && (bvm = this.gYX.bvm()) != null && !StringUtils.isNull(bvm.bvr())) {
            return bvm.bvr();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> QD;
        if (this.gYP == null || (QD = this.gYP.QD()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = QD.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.QJ().getWidth();
                preLoadImageInfo.height = next.QJ().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.QJ().Rc()) {
                    preLoadImageInfo.imgUrl = next.QJ().QY();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.QJ().QX();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.QO() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.QO().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.QO().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.QO();
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
        if (this.aNx == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.aNx.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.gYI == 52) {
            return gYF;
        }
        if (this.gYI == 2) {
            return gYB;
        }
        if (this.gYI == 1) {
            return aOw;
        }
        if (this.gYI == 36) {
            return gYC;
        }
        if (this.gYI == 40 || this.gYI == 50) {
            return aNe;
        }
        if (this.gYI == 41) {
            return gYD;
        }
        if (this.gYI == 53) {
            return gYG;
        }
        if (bvJ() == 1) {
            return gYz;
        }
        return gYA;
    }

    public void setPostType(int i) {
        this.gYI = i;
    }

    public am bvS() {
        return this.gYQ;
    }

    public void a(am amVar) {
        this.gYQ = amVar;
    }

    public h bvT() {
        return this.gYX;
    }

    public com.baidu.tbadk.widget.richText.f QN() {
        if (this.gZb != null) {
            return this.gZb;
        }
        if (this.gYP != null && v.D(this.gYP.QD()) > 0) {
            Iterator<TbRichTextData> it = this.gYP.QD().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.gZb = next.QN();
                    return this.gZb;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo QL() {
        if (this.bcv != null) {
            return this.bcv;
        }
        if (this.gYP != null && v.D(this.gYP.QD()) > 0) {
            Iterator<TbRichTextData> it = this.gYP.QD().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.bcv = next.QL();
                    return this.bcv;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.c> bvU() {
        return this.aOt;
    }

    public String bvV() {
        return this.gZc;
    }

    public String bvW() {
        return this.gZd;
    }

    public String zM() {
        return this.aOy;
    }

    public void zP() {
        if (this.aNV == 0) {
            this.aNV = 1;
        }
    }

    public long bvX() {
        return this.dFM;
    }

    public void cR(long j) {
        this.dFM = j;
    }

    public boolean bvY() {
        return this.dFO;
    }

    public void mD(boolean z) {
        this.dFO = z;
    }

    public OriginalThreadInfo bvZ() {
        return this.aPc;
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        this.aPc = originalThreadInfo;
    }

    public int bwa() {
        return this.gZp;
    }
}
