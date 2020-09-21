package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements q, ah {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private List<HeadItem> ebx;
    private OriginalThreadInfo efS;
    private SkinInfo efm;
    private String efp;
    private Item egJ;
    private TbRichTextVoiceInfo ewN;
    private String kFR;
    private SmallTailInfo lcd;
    public int locate;
    private String moJ;
    private ArrayList<PostData> moN;
    private com.baidu.tbadk.data.c moU;
    private com.baidu.tbadk.data.f moV;
    private i moY;
    private bs moZ;
    public boolean mpb;
    private com.baidu.tbadk.widget.richText.j mpc;
    private String mpd;
    private String mpe;
    private TPointPost mpf;
    public int mpi;
    public boolean mpl;
    public AlaLiveInfoCoreData mpo;
    private boolean mps;
    public aq mpw;
    public List<PbContent> mpz;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId moA = BdUniqueId.gen();
    public static final BdUniqueId moB = BdUniqueId.gen();
    public static final BdUniqueId efn = BdUniqueId.gen();
    public static final BdUniqueId edx = BdUniqueId.gen();
    public static final BdUniqueId edC = BdUniqueId.gen();
    public static final BdUniqueId moC = BdUniqueId.gen();
    public static final BdUniqueId moD = BdUniqueId.gen();
    public static final BdUniqueId moE = BdUniqueId.gen();
    public static final BdUniqueId moF = BdUniqueId.gen();
    public static final BdUniqueId moG = BdUniqueId.gen();
    public static boolean moH = false;
    private int moI = 0;
    private boolean moO = false;
    private ArrayList<PostData> moP = null;
    private TbRichText moQ = null;
    private boolean moT = false;
    private boolean moW = false;
    private boolean moX = false;
    public boolean mpa = false;
    public int eeM = 0;
    private boolean mpg = false;
    public boolean iiU = false;
    public boolean mph = false;
    public boolean mpj = false;
    public boolean mpk = true;
    public boolean mpm = false;
    public boolean mpn = false;
    private boolean mpp = false;
    private int mpq = 0;
    private boolean mpr = true;
    public boolean mpt = false;
    public boolean mpu = false;
    public boolean mpv = false;
    public boolean mpx = false;
    public boolean mpy = false;
    private b mpA = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.mpw != null) {
                aq bkh = PostData.this.mpw.bkh();
                bkh.delete("obj_locate");
                bkh.ai("obj_locate", 7);
                TiebaStatic.log(bkh);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData eep = new MetaData();
    private ArrayList<l> moK = new ArrayList<>();
    private ArrayList<l> moL = new ArrayList<>();
    private int moM = 0;
    private int eeX = 0;
    private PraiseData eeA = new PraiseData();
    private ax moR = new ax();
    private c moS = new c();
    private ArrayList<com.baidu.tbadk.data.c> efj = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.moN = null;
        this.mpi = 0;
        this.moN = new ArrayList<>();
        this.mpi = 0;
    }

    public void wj(boolean z) {
        this.mps = z;
    }

    public boolean dAv() {
        return this.mps;
    }

    public ArrayList<PostData> dAw() {
        return this.moP;
    }

    public void dAx() {
        this.moP.clear();
        this.moP = null;
        this.moO = false;
    }

    public void w(PostData postData) {
        if (postData != null) {
            if (this.moP == null) {
                this.moP = new ArrayList<>();
                if (y.getCount(this.moN) > 2) {
                    this.moP.addAll(y.subList(this.moN, 0, 2));
                } else {
                    this.moP.addAll(this.moN);
                }
            }
            this.moP.add(postData);
        }
    }

    public void x(PostData postData) {
        if (postData != null && this.moN != null) {
            this.moN.add(postData);
            dAB();
        }
    }

    public void Rn(String str) {
        if (this.moP != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.moP.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.moP.remove(next);
                    return;
                }
            }
        }
    }

    public void wk(boolean z) {
        this.mpr = z;
    }

    public boolean dAy() {
        return this.mpr;
    }

    public void wl(boolean z) {
        this.moO = z;
    }

    public boolean dAz() {
        return this.moO;
    }

    public ArrayList<PostData> dAA() {
        return this.moN;
    }

    public void dAB() {
        this.moM++;
    }

    public void dAC() {
        this.moM--;
    }

    public void Ir(int i) {
        this.moM = i;
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

    public int dAD() {
        return this.floor_num;
    }

    public void Is(int i) {
        this.floor_num = i;
    }

    public boolean dAE() {
        return this.moX;
    }

    public void wm(boolean z) {
        this.moX = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = at.getFormatTime(j);
    }

    public MetaData bfy() {
        return this.eep;
    }

    public void a(MetaData metaData) {
        this.eep = metaData;
    }

    public void a(PraiseData praiseData) {
        this.eeA = praiseData;
    }

    public TbRichText dAF() {
        return this.moQ;
    }

    public void c(TbRichText tbRichText) {
        this.moQ = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo dgO() {
        return this.lcd;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.lcd = smallTailInfo;
    }

    public com.baidu.tbadk.data.f dAG() {
        return this.moV;
    }

    public SkinInfo bfU() {
        return this.efm;
    }

    public void wn(boolean z) {
        this.mpp = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.moQ != null && this.moQ.byG() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.eep != null && this.eep.getIs_bawu() == 1) {
                    if (this.mps) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.eep.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.eep.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.eep.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.eep.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = bfy().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.mR().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.mR().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.moQ.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.j(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.eep.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.eep.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.eep == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.eep.getName_show() + str + "：");
                str2 = this.eep.getUserName();
                str3 = this.eep.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.eep.getSealPrefix())) {
                Bitmap bitmap = ap.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.eep.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.mpA), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.eep != null && this.eep.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.eep != null && this.eep.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.eep != null) {
                        int i3 = 0;
                        if (this.eep.getName_show() != null) {
                            i3 = this.eep.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> byG = this.moQ.byG();
            if (byG != null && byG.size() > 0) {
                TbRichTextData tbRichTextData2 = byG.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.byN() != null) {
                    if (this.mpp) {
                        int indexOf = tbRichTextData2.byN().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.byN().delete(0, indexOf + 1);
                        }
                        this.mpp = false;
                    }
                    tbRichTextData2.rG(sb.length());
                    tbRichTextData2.byN().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= byG.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (byG.get(i5) == null || byG.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo byO = byG.get(i5).byO();
                            byG.remove(i5);
                            tbRichTextVoiceInfo = byO;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.rG(sb.length());
                    tbRichTextData.n(spannableString);
                    byG.add(0, tbRichTextData);
                }
            }
            this.mpt = true;
        }
    }

    private com.baidu.tbadk.core.view.b e(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.iq(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.oK(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.AV(str);
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
        bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
        return bitmapDrawable;
    }

    public int dAH() {
        return this.moM;
    }

    public void fK(Context context) {
        int type;
        int i;
        int i2;
        if (this.moK != null) {
            int i3 = -1;
            int size = this.moL.size();
            if (size > 0) {
                try {
                    i3 = this.moL.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.moK.size()) {
                l lVar = this.moK.get(i4);
                if (l.dp(i5, lVar.getType())) {
                    this.moL.get(size - 1).b(lVar.fJ(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.moL.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.fJ(context));
                        this.moL.add(lVar2);
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

    public void fL(Context context) {
        try {
            if (this.moQ != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.moQ.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.moL == null || this.moL.size() == 0) {
                fK(context);
            }
            ArrayList<l> arrayList = this.moL;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dAn() != null) {
                            sb.append((CharSequence) next.dAn());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String Cm = TbFaceManager.bua().Cm(next.getText());
                        if (Cm != null) {
                            sb.append("[");
                            sb.append(Cm);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !at.isEmpty(next.dAm())) {
                        sb.append("[").append(next.dAm()).append("]");
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
                this.date = at.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.moW = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eep = metaData;
                }
                if (this.eep.getUserId() == null || this.eep.getUserId().length() <= 0 || this.eep.getUserId().equals("0")) {
                    this.eep = metaData2;
                }
                this.moQ = TbRichTextView.a(context, subPostList.content, z);
                if (this.moQ != null) {
                    this.moQ.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        TbRichTextData tbRichTextData;
        int i;
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = at.getFormatTime(this.time);
                this.moJ = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eep = metaData;
                }
                this.iiU = post.need_log.intValue() == 1;
                this.mph = post.img_num_abtest.intValue() == 1;
                this.moZ = new bs();
                this.moZ.parserProtobuf(post.from_forum);
                if (this.eep.getUserId() == null || this.eep.getUserId().length() <= 0 || this.eep.getUserId().equals("0")) {
                    this.eep.parserProtobuf(post.author);
                }
                if (this.eep != null && context != null) {
                    this.mpd = this.eep.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.mpe = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.eep.getLevel_id()));
                }
                this.moT = post.is_ntitle.intValue() == 1;
                this.moM = post.sub_post_number.intValue();
                this.moY = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.mpz = post.content;
                this.mpx = post.is_wonderful_post.intValue() == 1;
                this.mpu = post.is_top_agree_post.intValue() == 1;
                this.ebx = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.egJ = post.item;
                }
                this.moQ = TbRichTextView.a(context, list, true);
                if (this.moQ != null) {
                    this.moQ.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.moQ.rF(this.floor_num);
                    if (this.eep != null) {
                        this.moQ.setAuthorId(this.eep.getUserId());
                    }
                    int count = y.getCount(this.ebx);
                    if (this.floor_num == 1 && count != 0 && this.ebx != null) {
                        ArrayList<TbRichTextData> byG = this.moQ.byG();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) y.getItem(byG, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                y.add(byG, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) y.getItem(this.ebx, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.o(com.baidu.tbadk.widget.richText.e.G(i, false));
                            }
                        } else {
                            for (int size = this.ebx.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.ebx.get(size);
                                if (headItem2 != null) {
                                    a(byG, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.egJ != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.egJ));
                        y.add(this.moQ.byG(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.moW = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.wj(this.mps);
                            postData.a(subPostList, context);
                            this.moN.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.moS.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.moU = new com.baidu.tbadk.data.c();
                    this.moU.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.moV = new com.baidu.tbadk.data.f();
                    this.moV.a(post.lbs_info);
                }
                this.eeX = post.storecount.intValue();
                this.moR.a(post.present);
                this.eeA.setUserMap(this.userMap);
                this.eeA.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.lcd = new SmallTailInfo();
                    this.lcd.id = post.signature.signature_id.intValue();
                    this.lcd.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.lcd.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.lcd.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.lcd.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.efj.add(cVar);
                    }
                }
                this.efm = post.skin_info;
                this.efp = post.lego_card;
                this.mpf = post.tpoint_post;
                if (post.agree != null) {
                    this.mpg = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.mpg = false;
                }
                this.mpn = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.efS = new OriginalThreadInfo();
                    this.efS.a(post.origin_thread_info);
                } else {
                    this.efS = null;
                }
                this.mpq = post.is_fold.intValue();
                this.kFR = post.fold_tip;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(headItem.name + ": " + (headItem.type.intValue() == 1 ? headItem.content : " ")));
        if (headItem.type.intValue() == 2) {
            try {
                i = Integer.parseInt(headItem.content);
            } catch (NumberFormatException e) {
                i = 0;
            }
            spannableStringBuilder.append((CharSequence) com.baidu.tbadk.widget.richText.e.G(i, true));
        }
        tbRichTextData.n(spannableStringBuilder);
        y.add(list, 0, tbRichTextData);
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private String mId;
        private String mName;
        private SoftReference<Context> mpG;
        private b mpH;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.mpG = new SoftReference<>(context);
            this.mpH = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.mpG != null && this.mpG.get() != null) {
                if (this.mpH != null) {
                    this.mpH.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mpG.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fM(Context context) {
        ArrayList<TbRichTextData> byG;
        if (this.moQ == null || (byG = this.moQ.byG()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = byG.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.byN().toString());
            } else if (next.getType() == 17) {
                String str = next.byR().mGifInfo.mSharpText;
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

    public String dAI() {
        ArrayList<TbRichTextData> byG;
        String str;
        if (this.moQ == null || (byG = this.moQ.byG()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = byG.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.byN().toString());
                } else if (next.getType() == 17) {
                    if (next.byR() != null && next.byR().mGifInfo != null && (str = next.byR().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dAJ() {
        ArrayList<TbRichTextData> byG;
        if (this.moQ != null && (byG = this.moQ.byG()) != null) {
            Iterator<TbRichTextData> it = byG.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.byM().getWidth();
                    preLoadImageInfo.height = next.byM().getHeight();
                    preLoadImageInfo.imgUrl = next.byM().bzc();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.byS().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.byS().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.byS().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dAK() {
        k dAk;
        PreLoadImageInfo dAJ = dAJ();
        if (dAJ != null && !StringUtils.isNull(dAJ.imgUrl)) {
            return dAJ.imgUrl;
        }
        if (this.moY != null && (dAk = this.moY.dAk()) != null && !StringUtils.isNull(dAk.dAl())) {
            return dAk.dAl();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> byG;
        if (this.moQ == null || (byG = this.moQ.byG()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = byG.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.byM().getWidth();
                preLoadImageInfo.height = next.byM().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.byM().bzh()) {
                    preLoadImageInfo.imgUrl = next.byM().bzd();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.byM().bzc();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.byR() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.byR().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.byR().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.byR();
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
        if (this.eep == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.eep.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.moI == 52) {
            return moE;
        }
        if (this.moI == 1) {
            return efn;
        }
        if (this.moI == 36) {
            return edx;
        }
        if (this.moI == 40 || this.moI == 50) {
            return edC;
        }
        if (this.moI == 41) {
            return moC;
        }
        if (this.moI == 53) {
            return moF;
        }
        if (dAD() == 1) {
            return moA;
        }
        return moB;
    }

    public void setPostType(int i) {
        this.moI = i;
    }

    public ax dAL() {
        return this.moR;
    }

    public void a(ax axVar) {
        this.moR = axVar;
    }

    public i dAM() {
        return this.moY;
    }

    public com.baidu.tbadk.widget.richText.j byQ() {
        if (this.mpc != null) {
            return this.mpc;
        }
        if (this.moQ != null && y.getCount(this.moQ.byG()) > 0) {
            Iterator<TbRichTextData> it = this.moQ.byG().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.mpc = next.byQ();
                    return this.mpc;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo byO() {
        if (this.ewN != null) {
            return this.ewN;
        }
        if (this.moQ != null && y.getCount(this.moQ.byG()) > 0) {
            Iterator<TbRichTextData> it = this.moQ.byG().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.ewN = next.byO();
                    return this.ewN;
                }
            }
        }
        return null;
    }

    public String dAN() {
        return this.mpd;
    }

    public String bgI() {
        return this.efp;
    }

    public void bgK() {
        if (this.eeM == 0) {
            this.eeM = 1;
        }
    }

    public long bgX() {
        return this.agreeData.disAgreeNum;
    }

    public int bgZ() {
        return this.agreeData.agreeType;
    }

    public AgreeData bhp() {
        return this.agreeData;
    }

    public OriginalThreadInfo dAO() {
        return this.efS;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.efS = originalThreadInfo;
    }

    public int dAP() {
        return this.mpq;
    }

    public String cZc() {
        return this.kFR;
    }
}
