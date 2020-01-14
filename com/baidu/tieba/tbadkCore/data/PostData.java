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
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
    private OriginalThreadInfo cPN;
    private SkinInfo cPh;
    private String cPk;
    private TbRichTextVoiceInfo dek;
    private String iAp;
    private SmallTailInfo iUU;
    private String izv;
    private ArrayList<PostData> kfE;
    private com.baidu.tbadk.data.c kfL;
    private com.baidu.tbadk.data.f kfM;
    private i kfP;
    private bf kfQ;
    public boolean kfS;
    private com.baidu.tbadk.widget.richText.i kfT;
    private String kfU;
    private String kfV;
    private TPointPost kfW;
    public int kfZ;
    public boolean kgc;
    public AlaLiveInfoCoreData kgf;
    private boolean kgj;
    private boolean kgm;
    public an kgo;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId kfq = BdUniqueId.gen();
    public static final BdUniqueId kfr = BdUniqueId.gen();
    public static final BdUniqueId cPi = BdUniqueId.gen();
    public static final BdUniqueId kfs = BdUniqueId.gen();
    public static final BdUniqueId cNv = BdUniqueId.gen();
    public static final BdUniqueId kft = BdUniqueId.gen();
    public static final BdUniqueId kfu = BdUniqueId.gen();
    public static final BdUniqueId kfv = BdUniqueId.gen();
    public static final BdUniqueId kfw = BdUniqueId.gen();
    public static final BdUniqueId kfx = BdUniqueId.gen();
    public static boolean kfy = false;
    private int kfz = 0;
    private boolean kfF = false;
    private ArrayList<PostData> kfG = null;
    private TbRichText kfH = null;
    private boolean kfK = false;
    private boolean kfN = false;
    private boolean kfO = false;
    public boolean kfR = false;
    public int cOH = 0;
    private boolean kfX = false;
    public boolean gtC = false;
    public boolean kfY = false;
    public boolean kga = false;
    public boolean kgb = true;
    public boolean kgd = false;
    public boolean kge = false;
    private boolean kgg = false;
    private int kgh = 0;
    private boolean kgi = true;
    public boolean kgk = false;
    public boolean kgl = false;
    public boolean kgn = false;
    private b kgp = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.kgo != null) {
                an aEl = PostData.this.kgo.aEl();
                aEl.delete("obj_locate");
                aEl.Z("obj_locate", 7);
                TiebaStatic.log(aEl);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int kfA = 0;
    private long time = 0;
    private String date = null;
    private MetaData cOj = new MetaData();
    private ArrayList<l> kfB = new ArrayList<>();
    private ArrayList<l> kfC = new ArrayList<>();
    private int kfD = 0;
    private int cOS = 0;
    private PraiseData cOv = new PraiseData();
    private ar kfI = new ar();
    private c kfJ = new c();
    private ArrayList<com.baidu.tbadk.data.c> cPe = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.kfE = null;
        this.kfZ = 0;
        this.kfE = new ArrayList<>();
        this.kfZ = 0;
    }

    public void sG(boolean z) {
        this.kgj = z;
    }

    public boolean cJr() {
        return this.kgj;
    }

    public ArrayList<PostData> cJs() {
        return this.kfG;
    }

    public void cJt() {
        this.kfG.clear();
        this.kfG = null;
        this.kfF = false;
    }

    public void u(PostData postData) {
        if (postData != null) {
            if (this.kfG == null) {
                this.kfG = new ArrayList<>();
                if (v.getCount(this.kfE) > 2) {
                    this.kfG.addAll(v.subList(this.kfE, 0, 2));
                } else {
                    this.kfG.addAll(this.kfE);
                }
            }
            this.kfG.add(postData);
        }
    }

    public void v(PostData postData) {
        if (postData != null && this.kfE != null) {
            this.kfE.add(postData);
            cJx();
        }
    }

    public void IN(String str) {
        if (this.kfG != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.kfG.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.kfG.remove(next);
                    return;
                }
            }
        }
    }

    public void sH(boolean z) {
        this.kgi = z;
    }

    public boolean cJu() {
        return this.kgi;
    }

    public void sI(boolean z) {
        this.kfF = z;
    }

    public boolean cJv() {
        return this.kfF;
    }

    public ArrayList<PostData> cJw() {
        return this.kfE;
    }

    public void cJx() {
        this.kfD++;
    }

    public void cJy() {
        this.kfD--;
    }

    public void Cp(int i) {
        this.kfD = i;
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

    public String ciK() {
        return this.izv;
    }

    public int cJz() {
        return this.kfA;
    }

    public void Cq(int i) {
        this.kfA = i;
    }

    public boolean cJA() {
        return this.kfO;
    }

    public void sJ(boolean z) {
        this.kfO = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = aq.getFormatTime(j);
    }

    public MetaData azX() {
        return this.cOj;
    }

    public void a(MetaData metaData) {
        this.cOj = metaData;
    }

    public void a(PraiseData praiseData) {
        this.cOv = praiseData;
    }

    public TbRichText cJB() {
        return this.kfH;
    }

    public void c(TbRichText tbRichText) {
        this.kfH = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo cqG() {
        return this.iUU;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.iUU = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cJC() {
        return this.kfM;
    }

    public SkinInfo aAs() {
        return this.cPh;
    }

    public void sK(boolean z) {
        this.kgg = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.kfH != null && this.kfH.aRz() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.cOj != null && this.cOj.getIs_bawu() == 1) {
                    if (this.kgj) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.cOj.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.cOj.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.cOj.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.cOj.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = azX().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.gr().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.gr().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.kfH.isChanged = true;
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
            if (!StringUtils.isNull(this.cOj.getSealPrefix())) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
                sb.append(this.cOj.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
            }
            String sb2 = sb.toString();
            if (this.cOj == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.cOj.getName_show() + str + "：");
                str2 = this.cOj.getUserName();
                str3 = this.cOj.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.cOj.getSealPrefix())) {
                Bitmap bitmap = am.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.cOj.getSealPrefix().length() + 1;
                spannableString.setSpan(jVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.kgp), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.cOj != null && this.cOj.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.cOj != null && this.cOj.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.cOj != null) {
                        int i3 = 0;
                        if (this.cOj.getName_show() != null) {
                            i3 = this.cOj.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> aRz = this.kfH.aRz();
            if (aRz != null && aRz.size() > 0) {
                TbRichTextData tbRichTextData2 = aRz.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.aRG() != null) {
                    if (this.kgg) {
                        int indexOf = tbRichTextData2.aRG().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.aRG().delete(0, indexOf + 1);
                        }
                        this.kgg = false;
                    }
                    tbRichTextData2.nc(sb.length());
                    tbRichTextData2.aRG().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= aRz.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (aRz.get(i5) == null || aRz.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo aRH = aRz.get(i5).aRH();
                            aRz.remove(i5);
                            tbRichTextVoiceInfo = aRH;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.nc(sb.length());
                    tbRichTextData.j(spannableString);
                    aRz.add(0, tbRichTextData);
                }
            }
            this.kgk = true;
        }
    }

    private com.baidu.tbadk.core.view.b e(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.fH(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.kE(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.tB(str);
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

    public int cJD() {
        return this.kfD;
    }

    public void fu(Context context) {
        int type;
        int i;
        int i2;
        if (this.kfB != null) {
            int i3 = -1;
            int size = this.kfC.size();
            if (size > 0) {
                try {
                    i3 = this.kfC.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.kfB.size()) {
                l lVar = this.kfB.get(i4);
                if (l.cH(i5, lVar.getType())) {
                    this.kfC.get(size - 1).b(lVar.ft(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.kfC.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.ft(context));
                        this.kfC.add(lVar2);
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

    public void fv(Context context) {
        try {
            if (this.kfH != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.kfH.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.kfC == null || this.kfC.size() == 0) {
                fu(context);
            }
            ArrayList<l> arrayList = this.kfC;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cJk() != null) {
                            sb.append((CharSequence) next.cJk());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String uM = TbFaceManager.aNr().uM(next.getText());
                        if (uM != null) {
                            sb.append("[");
                            sb.append(uM);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.cJj())) {
                        sb.append("[").append(next.cJj()).append("]");
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
                this.kfA = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.kfN = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cOj = metaData;
                }
                if (this.cOj.getUserId() == null || this.cOj.getUserId().length() <= 0 || this.cOj.getUserId().equals("0")) {
                    this.cOj = metaData2;
                }
                this.kfH = TbRichTextView.a(context, subPostList.content, z);
                if (this.kfH != null) {
                    this.kfH.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
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
                this.kfA = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.izv = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cOj = metaData;
                }
                this.gtC = post.need_log.intValue() == 1;
                this.kfY = post.img_num_abtest.intValue() == 1;
                this.kfQ = new bf();
                this.kfQ.parserProtobuf(post.from_forum);
                if (this.cOj.getUserId() == null || this.cOj.getUserId().length() <= 0 || this.cOj.getUserId().equals("0")) {
                    this.cOj.parserProtobuf(post.author);
                }
                if (this.cOj != null && context != null) {
                    this.kfU = this.cOj.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.kfV = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.cOj.getLevel_id()));
                }
                this.kfK = post.is_ntitle.intValue() == 1;
                this.kfD = post.sub_post_number.intValue();
                this.kfP = new i(post.tpoint_post);
                this.kfH = TbRichTextView.a(context, post.content, true);
                if (this.kfH != null) {
                    this.kfH.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.kfH.nb(this.kfA);
                    if (this.cOj != null) {
                        this.kfH.setAuthorId(this.cOj.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.kfN = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.sG(this.kgj);
                            postData.a(subPostList, context);
                            this.kfE.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.kfJ.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.kfL = new com.baidu.tbadk.data.c();
                    this.kfL.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.kfM = new com.baidu.tbadk.data.f();
                    this.kfM.a(post.lbs_info);
                }
                this.cOS = post.storecount.intValue();
                this.kfI.a(post.present);
                this.cOv.setUserMap(this.userMap);
                this.cOv.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.iUU = new SmallTailInfo();
                    this.iUU.id = post.signature.signature_id.intValue();
                    this.iUU.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.iUU.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.iUU.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.iUU.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.cPe.add(cVar);
                    }
                }
                this.cPh = post.skin_info;
                this.cPk = post.lego_card;
                this.kfW = post.tpoint_post;
                if (post.agree != null) {
                    this.kfX = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.kfX = false;
                }
                this.kge = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.cPN = new OriginalThreadInfo();
                    this.cPN.a(post.origin_thread_info);
                } else {
                    this.cPN = null;
                }
                this.kgh = post.is_fold.intValue();
                this.iAp = post.fold_tip;
                this.kgl = post.is_top_agree_post.intValue() == 1;
                this.kgm = post.show_squared.intValue() == 1;
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
        private SoftReference<Context> kgv;
        private b kgw;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.kgv = new SoftReference<>(context);
            this.kgw = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.kgv != null && this.kgv.get() != null) {
                if (this.kgw != null) {
                    this.kgw.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.kgv.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fw(Context context) {
        ArrayList<TbRichTextData> aRz;
        if (this.kfH == null || (aRz = this.kfH.aRz()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = aRz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.aRG().toString());
            } else if (next.getType() == 17) {
                String str = next.aRK().mGifInfo.mSharpText;
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

    public String cJE() {
        ArrayList<TbRichTextData> aRz;
        String str;
        if (this.kfH == null || (aRz = this.kfH.aRz()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = aRz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.aRG().toString());
                } else if (next.getType() == 17) {
                    if (next.aRK() != null && next.aRK().mGifInfo != null && (str = next.aRK().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cJF() {
        ArrayList<TbRichTextData> aRz;
        if (this.kfH != null && (aRz = this.kfH.aRz()) != null) {
            Iterator<TbRichTextData> it = aRz.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.aRF().getWidth();
                    preLoadImageInfo.height = next.aRF().getHeight();
                    preLoadImageInfo.imgUrl = next.aRF().aRT();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.aRL().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.aRL().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.aRL().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cJG() {
        k cJc;
        PreLoadImageInfo cJF = cJF();
        if (cJF != null && !StringUtils.isNull(cJF.imgUrl)) {
            return cJF.imgUrl;
        }
        if (this.kfP != null && (cJc = this.kfP.cJc()) != null && !StringUtils.isNull(cJc.cJh())) {
            return cJc.cJh();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> aRz;
        if (this.kfH == null || (aRz = this.kfH.aRz()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = aRz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.aRF().getWidth();
                preLoadImageInfo.height = next.aRF().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.aRF().aRY()) {
                    preLoadImageInfo.imgUrl = next.aRF().aRU();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.aRF().aRT();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.aRK() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.aRK().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.aRK().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.aRK();
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
        if (this.cOj == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.cOj.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.kfz == 52) {
            return kfv;
        }
        if (this.kfz == 1) {
            return cPi;
        }
        if (this.kfz == 36) {
            return kfs;
        }
        if (this.kfz == 40 || this.kfz == 50) {
            return cNv;
        }
        if (this.kfz == 41) {
            return kft;
        }
        if (this.kfz == 53) {
            return kfw;
        }
        if (cJz() == 1) {
            return kfq;
        }
        return kfr;
    }

    public void setPostType(int i) {
        this.kfz = i;
    }

    public ar cJH() {
        return this.kfI;
    }

    public void a(ar arVar) {
        this.kfI = arVar;
    }

    public i cJI() {
        return this.kfP;
    }

    public com.baidu.tbadk.widget.richText.i aRJ() {
        if (this.kfT != null) {
            return this.kfT;
        }
        if (this.kfH != null && v.getCount(this.kfH.aRz()) > 0) {
            Iterator<TbRichTextData> it = this.kfH.aRz().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.kfT = next.aRJ();
                    return this.kfT;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo aRH() {
        if (this.dek != null) {
            return this.dek;
        }
        if (this.kfH != null && v.getCount(this.kfH.aRz()) > 0) {
            Iterator<TbRichTextData> it = this.kfH.aRz().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.dek = next.aRH();
                    return this.dek;
                }
            }
        }
        return null;
    }

    public String cJJ() {
        return this.kfU;
    }

    public String aBf() {
        return this.cPk;
    }

    public void aBh() {
        if (this.cOH == 0) {
            this.cOH = 1;
        }
    }

    public long aBt() {
        return this.agreeData.disAgreeNum;
    }

    public AgreeData aBM() {
        return this.agreeData;
    }

    public OriginalThreadInfo cJK() {
        return this.cPN;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.cPN = originalThreadInfo;
    }

    public int cJL() {
        return this.kgh;
    }

    public String cja() {
        return this.iAp;
    }

    public boolean cJM() {
        return this.kgm;
    }
}
