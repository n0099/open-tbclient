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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
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
public class PostData implements com.baidu.adp.widget.ListView.m, ae {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private TbRichTextVoiceInfo dIP;
    private SkinInfo dsM;
    private String dsP;
    private OriginalThreadInfo dtt;
    private SmallTailInfo jIm;
    private String joe;
    private String kSC;
    private ArrayList<PostData> kSG;
    private com.baidu.tbadk.data.c kSN;
    private com.baidu.tbadk.data.f kSO;
    private i kSR;
    private bf kSS;
    public boolean kSU;
    private com.baidu.tbadk.widget.richText.i kSV;
    private String kSW;
    private String kSX;
    private TPointPost kSY;
    public int kTb;
    public boolean kTe;
    public AlaLiveInfoCoreData kTh;
    private boolean kTl;
    private boolean kTo;
    public an kTq;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId kSr = BdUniqueId.gen();
    public static final BdUniqueId kSs = BdUniqueId.gen();
    public static final BdUniqueId dsN = BdUniqueId.gen();
    public static final BdUniqueId kSt = BdUniqueId.gen();
    public static final BdUniqueId dqZ = BdUniqueId.gen();
    public static final BdUniqueId kSu = BdUniqueId.gen();
    public static final BdUniqueId kSv = BdUniqueId.gen();
    public static final BdUniqueId kSw = BdUniqueId.gen();
    public static final BdUniqueId kSx = BdUniqueId.gen();
    public static final BdUniqueId kSy = BdUniqueId.gen();
    public static boolean kSz = false;
    private int kSA = 0;
    private boolean kSH = false;
    private ArrayList<PostData> kSI = null;
    private TbRichText kSJ = null;
    private boolean kSM = false;
    private boolean kSP = false;
    private boolean kSQ = false;
    public boolean kST = false;
    public int dsl = 0;
    private boolean kSZ = false;
    public boolean hfP = false;
    public boolean kTa = false;
    public boolean kTc = false;
    public boolean kTd = true;
    public boolean kTf = false;
    public boolean kTg = false;
    private boolean kTi = false;
    private int kTj = 0;
    private boolean kTk = true;
    public boolean kTm = false;
    public boolean kTn = false;
    public boolean kTp = false;
    private b kTr = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.kTq != null) {
                an aON = PostData.this.kTq.aON();
                aON.delete("obj_locate");
                aON.af("obj_locate", 7);
                TiebaStatic.log(aON);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int kSB = 0;
    private long time = 0;
    private String date = null;
    private MetaData drO = new MetaData();
    private ArrayList<l> kSD = new ArrayList<>();
    private ArrayList<l> kSE = new ArrayList<>();
    private int kSF = 0;
    private int dsx = 0;
    private PraiseData drZ = new PraiseData();
    private ar kSK = new ar();
    private c kSL = new c();
    private ArrayList<com.baidu.tbadk.data.c> dsJ = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.kSG = null;
        this.kTb = 0;
        this.kSG = new ArrayList<>();
        this.kTb = 0;
    }

    public void tS(boolean z) {
        this.kTl = z;
    }

    public boolean cWh() {
        return this.kTl;
    }

    public ArrayList<PostData> cWi() {
        return this.kSI;
    }

    public void cWj() {
        this.kSI.clear();
        this.kSI = null;
        this.kSH = false;
    }

    public void t(PostData postData) {
        if (postData != null) {
            if (this.kSI == null) {
                this.kSI = new ArrayList<>();
                if (v.getCount(this.kSG) > 2) {
                    this.kSI.addAll(v.subList(this.kSG, 0, 2));
                } else {
                    this.kSI.addAll(this.kSG);
                }
            }
            this.kSI.add(postData);
        }
    }

    public void u(PostData postData) {
        if (postData != null && this.kSG != null) {
            this.kSG.add(postData);
            cWn();
        }
    }

    public void KO(String str) {
        if (this.kSI != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.kSI.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.kSI.remove(next);
                    return;
                }
            }
        }
    }

    public void tT(boolean z) {
        this.kTk = z;
    }

    public boolean cWk() {
        return this.kTk;
    }

    public void tU(boolean z) {
        this.kSH = z;
    }

    public boolean cWl() {
        return this.kSH;
    }

    public ArrayList<PostData> cWm() {
        return this.kSG;
    }

    public void cWn() {
        this.kSF++;
    }

    public void cWo() {
        this.kSF--;
    }

    public void Dh(int i) {
        this.kSF = i;
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

    public long getTid() {
        return this.tid;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cWp() {
        return this.kSB;
    }

    public void Di(int i) {
        this.kSB = i;
    }

    public boolean cWq() {
        return this.kSQ;
    }

    public void tV(boolean z) {
        this.kSQ = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = aq.getFormatTime(j);
    }

    public MetaData aKC() {
        return this.drO;
    }

    public void a(MetaData metaData) {
        this.drO = metaData;
    }

    public void a(PraiseData praiseData) {
        this.drZ = praiseData;
    }

    public TbRichText cWr() {
        return this.kSJ;
    }

    public void c(TbRichText tbRichText) {
        this.kSJ = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo cCZ() {
        return this.jIm;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.jIm = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cWs() {
        return this.kSO;
    }

    public SkinInfo aKX() {
        return this.dsM;
    }

    public void tW(boolean z) {
        this.kTi = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.kSJ != null && this.kSJ.bcf() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.drO != null && this.drO.getIs_bawu() == 1) {
                    if (this.kTl) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.drO.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.drO.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.drO.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.drO.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = aKC().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.kV().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.kV().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.kSJ.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.j(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.drO.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.drO.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.drO == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.drO.getName_show() + str + "：");
                str2 = this.drO.getUserName();
                str3 = this.drO.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.drO.getSealPrefix())) {
                Bitmap bitmap = am.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.drO.getSealPrefix().length() + 1;
                spannableString.setSpan(jVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.kTr), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.drO != null && this.drO.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.drO != null && this.drO.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.drO != null) {
                        int i3 = 0;
                        if (this.drO.getName_show() != null) {
                            i3 = this.drO.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bcf = this.kSJ.bcf();
            if (bcf != null && bcf.size() > 0) {
                TbRichTextData tbRichTextData2 = bcf.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bcm() != null) {
                    if (this.kTi) {
                        int indexOf = tbRichTextData2.bcm().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bcm().delete(0, indexOf + 1);
                        }
                        this.kTi = false;
                    }
                    tbRichTextData2.nH(sb.length());
                    tbRichTextData2.bcm().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bcf.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bcf.get(i5) == null || bcf.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo bcn = bcf.get(i5).bcn();
                            bcf.remove(i5);
                            tbRichTextVoiceInfo = bcn;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.nH(sb.length());
                    tbRichTextData.j(spannableString);
                    bcf.add(0, tbRichTextData);
                }
            }
            this.kTm = true;
        }
    }

    private com.baidu.tbadk.core.view.b e(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.gN(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.lf(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.vi(str);
            return bVar;
        }
        return bVar;
    }

    protected Drawable j(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36));
        return bitmapDrawable;
    }

    public int cWt() {
        return this.kSF;
    }

    public void eZ(Context context) {
        int type;
        int i;
        int i2;
        if (this.kSD != null) {
            int i3 = -1;
            int size = this.kSE.size();
            if (size > 0) {
                try {
                    i3 = this.kSE.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.kSD.size()) {
                l lVar = this.kSD.get(i4);
                if (l.cQ(i5, lVar.getType())) {
                    this.kSE.get(size - 1).b(lVar.eY(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.kSE.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.eY(context));
                        this.kSE.add(lVar2);
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

    public void fa(Context context) {
        try {
            if (this.kSJ != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.kSJ.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.kSE == null || this.kSE.size() == 0) {
                eZ(context);
            }
            ArrayList<l> arrayList = this.kSE;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cWa() != null) {
                            sb.append((CharSequence) next.cWa());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String wu = TbFaceManager.aYj().wu(next.getText());
                        if (wu != null) {
                            sb.append("[");
                            sb.append(wu);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.cVZ())) {
                        sb.append("[").append(next.cVZ()).append("]");
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
                this.kSB = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.kSP = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.drO = metaData;
                }
                if (this.drO.getUserId() == null || this.drO.getUserId().length() <= 0 || this.drO.getUserId().equals("0")) {
                    this.drO = metaData2;
                }
                this.kSJ = TbRichTextView.a(context, subPostList.content, z);
                if (this.kSJ != null) {
                    this.kSJ.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
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
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.kSB = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.kSC = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.drO = metaData;
                }
                this.hfP = post.need_log.intValue() == 1;
                this.kTa = post.img_num_abtest.intValue() == 1;
                this.kSS = new bf();
                this.kSS.parserProtobuf(post.from_forum);
                if (this.drO.getUserId() == null || this.drO.getUserId().length() <= 0 || this.drO.getUserId().equals("0")) {
                    this.drO.parserProtobuf(post.author);
                }
                if (this.drO != null && context != null) {
                    this.kSW = this.drO.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.kSX = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.drO.getLevel_id()));
                }
                this.kSM = post.is_ntitle.intValue() == 1;
                this.kSF = post.sub_post_number.intValue();
                this.kSR = new i(post.tpoint_post);
                this.kSJ = TbRichTextView.a(context, post.content, true);
                if (this.kSJ != null) {
                    this.kSJ.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.kSJ.nG(this.kSB);
                    if (this.drO != null) {
                        this.kSJ.setAuthorId(this.drO.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.kSP = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.tS(this.kTl);
                            postData.a(subPostList, context);
                            this.kSG.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.kSL.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.kSN = new com.baidu.tbadk.data.c();
                    this.kSN.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.kSO = new com.baidu.tbadk.data.f();
                    this.kSO.a(post.lbs_info);
                }
                this.dsx = post.storecount.intValue();
                this.kSK.a(post.present);
                this.drZ.setUserMap(this.userMap);
                this.drZ.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.jIm = new SmallTailInfo();
                    this.jIm.id = post.signature.signature_id.intValue();
                    this.jIm.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.jIm.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.jIm.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.jIm.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.dsJ.add(cVar);
                    }
                }
                this.dsM = post.skin_info;
                this.dsP = post.lego_card;
                this.kSY = post.tpoint_post;
                if (post.agree != null) {
                    this.kSZ = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.kSZ = false;
                }
                this.kTg = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.dtt = new OriginalThreadInfo();
                    this.dtt.a(post.origin_thread_info);
                } else {
                    this.dtt = null;
                }
                this.kTj = post.is_fold.intValue();
                this.joe = post.fold_tip;
                this.kTn = post.is_top_agree_post.intValue() == 1;
                this.kTo = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> kTx;
        private b kTy;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.kTx = new SoftReference<>(context);
            this.kTy = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.kTx != null && this.kTx.get() != null) {
                if (this.kTy != null) {
                    this.kTy.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.kTx.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fb(Context context) {
        ArrayList<TbRichTextData> bcf;
        if (this.kSJ == null || (bcf = this.kSJ.bcf()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bcf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bcm().toString());
            } else if (next.getType() == 17) {
                String str = next.bcq().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String cWu() {
        ArrayList<TbRichTextData> bcf;
        String str;
        if (this.kSJ == null || (bcf = this.kSJ.bcf()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bcf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bcm().toString());
                } else if (next.getType() == 17) {
                    if (next.bcq() != null && next.bcq().mGifInfo != null && (str = next.bcq().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cWv() {
        ArrayList<TbRichTextData> bcf;
        if (this.kSJ != null && (bcf = this.kSJ.bcf()) != null) {
            Iterator<TbRichTextData> it = bcf.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bcl().getWidth();
                    preLoadImageInfo.height = next.bcl().getHeight();
                    preLoadImageInfo.imgUrl = next.bcl().bcy();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bcr().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bcr().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bcr().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cWw() {
        k cVX;
        PreLoadImageInfo cWv = cWv();
        if (cWv != null && !StringUtils.isNull(cWv.imgUrl)) {
            return cWv.imgUrl;
        }
        if (this.kSR != null && (cVX = this.kSR.cVX()) != null && !StringUtils.isNull(cVX.cVY())) {
            return cVX.cVY();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bcf;
        if (this.kSJ == null || (bcf = this.kSJ.bcf()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bcf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bcl().getWidth();
                preLoadImageInfo.height = next.bcl().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bcl().bcD()) {
                    preLoadImageInfo.imgUrl = next.bcl().bcz();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bcl().bcy();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bcq() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bcq().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bcq().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bcq();
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
        if (this.drO == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.drO.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.kSA == 52) {
            return kSw;
        }
        if (this.kSA == 1) {
            return dsN;
        }
        if (this.kSA == 36) {
            return kSt;
        }
        if (this.kSA == 40 || this.kSA == 50) {
            return dqZ;
        }
        if (this.kSA == 41) {
            return kSu;
        }
        if (this.kSA == 53) {
            return kSx;
        }
        if (cWp() == 1) {
            return kSr;
        }
        return kSs;
    }

    public void setPostType(int i) {
        this.kSA = i;
    }

    public ar cWx() {
        return this.kSK;
    }

    public void a(ar arVar) {
        this.kSK = arVar;
    }

    public i cWy() {
        return this.kSR;
    }

    public com.baidu.tbadk.widget.richText.i bcp() {
        if (this.kSV != null) {
            return this.kSV;
        }
        if (this.kSJ != null && v.getCount(this.kSJ.bcf()) > 0) {
            Iterator<TbRichTextData> it = this.kSJ.bcf().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.kSV = next.bcp();
                    return this.kSV;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bcn() {
        if (this.dIP != null) {
            return this.dIP;
        }
        if (this.kSJ != null && v.getCount(this.kSJ.bcf()) > 0) {
            Iterator<TbRichTextData> it = this.kSJ.bcf().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.dIP = next.bcn();
                    return this.dIP;
                }
            }
        }
        return null;
    }

    public String cWz() {
        return this.kSW;
    }

    public String aLJ() {
        return this.dsP;
    }

    public void aLL() {
        if (this.dsl == 0) {
            this.dsl = 1;
        }
    }

    public long aLY() {
        return this.agreeData.disAgreeNum;
    }

    public AgreeData aMq() {
        return this.agreeData;
    }

    public OriginalThreadInfo cWA() {
        return this.dtt;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.dtt = originalThreadInfo;
    }

    public int cWB() {
        return this.kTj;
    }

    public String cvA() {
        return this.joe;
    }

    public boolean cWC() {
        return this.kTo;
    }
}
