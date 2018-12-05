package com.baidu.tieba.video.meida;

import android.support.v4.internal.view.SupportMenu;
import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;
/* loaded from: classes5.dex */
public class j {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int[] hFK;
    private static final int[] hFL;
    private static final int[] hFM;
    private static final double[][] hFN;
    private static final double[] hFZ;
    private ByteOrder hFF;
    private k hFG;
    private double hFH;
    private double hFI;
    private int hFJ;
    private double[][] hFO;
    private int hFP;
    private int hFQ;
    private int hFR;
    private int hFS;
    private double[] hFT;
    private int hFU;
    private boolean hFV;
    private int hFW;
    private long hFX;
    private long hFY;

    static {
        $assertionsDisabled = !j.class.desiredAssertionStatus();
        hFK = new int[]{0, 48000, 44100, 37800, 32000, 22050, 48000, 44100};
        hFL = new int[]{1, 16, 20, 16, 16, 15, 16, 15};
        hFM = new int[]{8, 18, 27, 8, 8, 8, 10, 9};
        hFN = new double[][]{new double[]{-1.0d}, new double[]{-2.87207293510437d, 5.041323184967041d, -6.244299411773682d, 5.848398685455322d, -3.706754207611084d, 1.0495119094848633d, 1.1830236911773682d, -2.1126792430877686d, 1.9094531536102295d, -0.9991308450698853d, 0.17090806365013123d, 0.32615602016448975d, -0.39127644896507263d, 0.2687646150588989d, -0.0976761057972908d, 0.023473845794796944d}, new double[]{-2.6773197650909424d, 4.830892562866211d, -6.570110321044922d, 7.4572014808654785d, -6.726327419281006d, 4.848165035247803d, -2.0412089824676514d, -0.7006359100341797d, 2.95375657081604d, -4.080038547515869d, 4.184521675109863d, -3.331181287765503d, 2.117992639541626d, -0.879302978515625d, 0.031759146600961685d, 0.4238278865814209d, -0.4788210391998291d, 0.35490813851356506d, -0.1749683916568756d, 0.06090816855430603d}, new double[]{-1.6335992813110352d, 2.261549234390259d, -2.407702922821045d, 2.634171724319458d, -2.144036293029785d, 1.8153258562088013d, -1.0816224813461304d, 0.703026533126831d, -0.15991993248462677d, -0.04154951870441437d, 0.2941657602787018d, -0.25183168053627014d, 0.27766478061676025d, -0.15785403549671173d, 0.10165894031524658d, -0.016833892092108727d}, new double[]{-0.8290129899978638d, 0.9892265796661377d, -0.5982571244239807d, 1.0028809309005737d, -0.5993821620941162d, 0.7950245141983032d, -0.42723315954208374d, 0.5449252724647522d, -0.3079260587692261d, 0.3687179982662201d, -0.187920480966568d, 0.2261127084493637d, -0.10573341697454453d, 0.11435490846633911d, -0.0388006791472435d, 0.040842197835445404d}, new double[]{-0.06522997468709946d, 0.5498126149177551d, 0.4027854800224304d, 0.3178376853466034d, 0.2820179760456085d, 0.16985194385051727d, 0.15433363616466522d, 0.12507140636444092d, 0.08903945237398148d, 0.06441012024879456d, 0.04714600369334221d, 0.03280523791909218d, 0.028495194390416145d, 0.011695005930960178d, 0.011831838637590408d}, new double[]{-2.3925774097442627d, 3.4350297451019287d, -3.185370922088623d, 1.8117271661758423d, 0.2012477070093155d, -1.4759907722473145d, 1.7210904359817505d, -0.9774670004844666d, 0.13790138065814972d, 0.38185903429985046d, -0.27421241998672485d, -0.06658421456813812d, 0.35223302245140076d, -0.37672343850135803d, 0.23964276909828186d, -0.06867482513189316d}, new double[]{-2.0833916664123535d, 3.0418450832366943d, -3.204789876937866d, 2.757192611694336d, -1.4978630542755127d, 0.34275946021080017d, 0.7173374891281128d, -1.073705792427063d, 1.0225815773010254d, -0.5664999485015869d, 0.20968692004680634d, 0.06537853181362152d, -0.10322438180446625d, 0.06744202226400375d, 0.00495197344571352d}};
        hFZ = new double[]{0.7d, 0.9d, 0.18d};
    }

    private int j(double d) {
        return d >= 0.0d ? (int) (d + 0.5d) : (int) (d - 0.5d);
    }

    public int a(int i, int i2, int i3, int i4, int i5, int i6, double d) {
        int[] iArr = new int[97];
        int i7 = 1;
        while (i7 < 6 && i != hFK[i7]) {
            i7++;
        }
        if ((i5 == 3 || i5 == 4) && i7 == 6) {
            System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", Integer.valueOf(i));
        }
        i7 = (i5 == 2 || i7 == 6) ? 0 : 0;
        if (i5 == 4 && (i7 == 1 || i7 == 2)) {
            i7 += 5;
        }
        this.hFP = i7;
        this.hFO = new double[i2];
        this.hFQ = hFL[this.hFP];
        for (int i8 = 0; i8 < i2; i8++) {
            this.hFO[i8] = new double[this.hFQ];
        }
        this.hFR = i3;
        this.hFS = i4;
        this.hFT = new double[65536];
        Random random = new Random(System.currentTimeMillis());
        for (int i9 = 0; i9 < 97; i9++) {
            iArr[i9] = random.nextInt();
        }
        switch (i6) {
            case 0:
                for (int i10 = 0; i10 < 65536; i10++) {
                    int nextInt = random.nextInt() % 97;
                    int i11 = iArr[nextInt];
                    iArr[nextInt] = random.nextInt();
                    this.hFT[i10] = ((i11 / 2.147483647E9d) - 0.5d) * d;
                }
                break;
            case 1:
                for (int i12 = 0; i12 < 65536; i12++) {
                    int nextInt2 = random.nextInt() % 97;
                    int i13 = iArr[nextInt2];
                    iArr[nextInt2] = random.nextInt();
                    int nextInt3 = random.nextInt() % 97;
                    int i14 = iArr[nextInt3];
                    iArr[nextInt3] = random.nextInt();
                    this.hFT[i12] = ((i13 / 2.147483647E9d) - (i14 / 2.147483647E9d)) * d;
                }
                break;
            case 2:
                boolean z = false;
                double d2 = 0.0d;
                double d3 = 0.0d;
                for (int i15 = 0; i15 < 65536; i15++) {
                    if (!z) {
                        z = true;
                        int nextInt4 = random.nextInt() % 97;
                        double d4 = iArr[nextInt4] / 2.147483647E9d;
                        iArr[nextInt4] = random.nextInt();
                        if (d4 == 1.0d) {
                            d4 = 0.0d;
                        }
                        d2 = Math.sqrt(Math.log(1.0d - d4) * (-2.0d));
                        int nextInt5 = random.nextInt() % 97;
                        iArr[nextInt5] = random.nextInt();
                        d3 = 6.283185307179586d * (iArr[nextInt5] / 2.147483647E9d);
                        this.hFT[i15] = d * d2 * Math.cos(d3);
                    } else {
                        z = false;
                        this.hFT[i15] = d * d2 * Math.sin(d3);
                    }
                }
                break;
        }
        this.hFU = 0;
        if (i5 == 0 || i5 == 1) {
            return 1;
        }
        return hFM[this.hFP];
    }

    public int a(double d, double[] dArr, int i, int i2) {
        double j;
        if (i == 1) {
            double[] dArr2 = this.hFT;
            int i3 = this.hFU;
            this.hFU = i3 + 1;
            double d2 = dArr2[i3 & SupportMenu.USER_MASK] + d;
            if (d2 < this.hFR) {
                double d3 = d2 / this.hFR;
                if (dArr[0] >= d3) {
                    d3 = dArr[0];
                }
                dArr[0] = d3;
                d2 = this.hFR;
            }
            if (d2 > this.hFS) {
                double d4 = d2 / this.hFS;
                if (dArr[0] >= d4) {
                    d4 = dArr[0];
                }
                dArr[0] = d4;
                d2 = this.hFS;
            }
            return j(d2);
        }
        double d5 = 0.0d;
        for (int i4 = 0; i4 < this.hFQ; i4++) {
            d5 += hFN[this.hFP][i4] * this.hFO[i2][i4];
        }
        double d6 = d5 + d;
        double[] dArr3 = this.hFT;
        int i5 = this.hFU;
        this.hFU = i5 + 1;
        double d7 = d6 + dArr3[i5 & SupportMenu.USER_MASK];
        for (int i6 = this.hFQ - 2; i6 >= 0; i6--) {
            this.hFO[i2][i6 + 1] = this.hFO[i2][i6];
        }
        if (d7 < this.hFR) {
            double d8 = d7 / this.hFR;
            if (dArr[0] >= d8) {
                d8 = dArr[0];
            }
            dArr[0] = d8;
            j = this.hFR;
            this.hFO[i2][0] = j - d6;
            if (this.hFO[i2][0] > 1.0d) {
                this.hFO[i2][0] = 1.0d;
            }
            if (this.hFO[i2][0] < -1.0d) {
                this.hFO[i2][0] = -1.0d;
            }
        } else if (d7 > this.hFS) {
            double d9 = d7 / this.hFS;
            if (dArr[0] >= d9) {
                d9 = dArr[0];
            }
            dArr[0] = d9;
            j = this.hFS;
            this.hFO[i2][0] = j - d6;
            if (this.hFO[i2][0] > 1.0d) {
                this.hFO[i2][0] = 1.0d;
            }
            if (this.hFO[i2][0] < -1.0d) {
                this.hFO[i2][0] = -1.0d;
            }
        } else {
            j = j(d7);
            this.hFO[i2][0] = j - d6;
        }
        return (int) j;
    }

    private void wy(int i) {
    }

    private double k(double d) {
        if (d <= 21.0d) {
            return 0.0d;
        }
        if (d <= 50.0d) {
            return (0.5842d * Math.pow(d - 21.0d, 0.4d)) + (0.07886d * (d - 21.0d));
        }
        return 0.1102d * (d - 8.7d);
    }

    private double a(double d, int i, double d2, double d3) {
        return f.i(Math.sqrt(1.0d - (((4.0d * d) * d) / ((i - 1.0d) * (i - 1.0d)))) * d2) / d3;
    }

    private double l(double d) {
        if (d == 0.0d) {
            return 1.0d;
        }
        return Math.sin(d) / d;
    }

    private double c(int i, double d, double d2) {
        double d3 = 1.0d / d2;
        return l(d3 * 6.283185307179586d * d * i) * 2.0d * d * d3;
    }

    private void bJN() {
        this.hFX = System.currentTimeMillis();
        this.hFY = 0L;
        this.hFW = -1;
    }

    private void m(double d) {
        if (!this.hFV) {
            long currentTimeMillis = System.currentTimeMillis() - this.hFX;
            int i = d == 0.0d ? 0 : (int) ((currentTimeMillis * (1.0d - d)) / d);
            int i2 = (int) (100.0d * d);
            if (i2 != this.hFW || currentTimeMillis != this.hFY) {
                System.err.printf(" %3d%% processed", Integer.valueOf(i2));
                this.hFW = i2;
            }
            if (currentTimeMillis != this.hFY) {
                System.err.printf(", ETA =%4dmsec", Integer.valueOf(i));
                this.hFY = currentTimeMillis;
            }
            System.err.printf("\r", new Object[0]);
            System.err.flush();
        }
    }

    private int gcd(int i, int i2) {
        while (i2 != 0) {
            int i3 = i % i2;
            i = i2;
            i2 = i3;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:251:0x0980  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0991 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double a(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, double d, int i6, boolean z, int i7) throws IOException {
        int i8;
        double d2;
        double d3;
        int i9;
        double d4;
        int i10;
        int i11;
        int j;
        int j2;
        int j3;
        int i12;
        int i13;
        boolean z2;
        int i14;
        int i15;
        double[] dArr = {0.0d};
        int i16 = 0;
        int i17 = this.hFJ;
        double d5 = this.hFH;
        int gcd = gcd(i4, i5);
        int i18 = (i4 / gcd) * i5;
        if (i18 / i5 == 1) {
            i8 = 1;
        } else if ((i18 / i5) % 2 == 0) {
            i8 = 2;
        } else if ((i18 / i5) % 3 == 0) {
            i8 = 3;
        } else {
            throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.\n", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i18 / i5)));
        }
        double d6 = ((((i5 * i8) / 2) - (i4 / 2)) * 2) / 2.0d;
        double d7 = (i4 / 2) + ((((i5 * i8) / 2) - (i4 / 2)) / 2.0d);
        if (d5 <= 21.0d) {
            d2 = 0.9222d;
        } else {
            d2 = (d5 - 7.95d) / 14.36d;
        }
        int i19 = (int) ((d2 * (i18 / d6)) + 1.0d);
        if (i19 % 2 == 0) {
            i19++;
        }
        double k = k(d5);
        double i20 = f.i(k);
        int i21 = i18 / i4;
        int i22 = (i19 / i21) + 1;
        int[] iArr = new int[i21 * i8];
        for (int i23 = 0; i23 < i21 * i8; i23++) {
            iArr[i23] = (i18 / i4) - (((i18 / (i5 * i8)) * i23) % (i18 / i4));
            if (iArr[i23] == i18 / i4) {
                iArr[i23] = 0;
            }
        }
        int[] iArr2 = new int[i21 * i8];
        int i24 = 0;
        while (true) {
            int i25 = i24;
            if (i25 >= i21 * i8) {
                break;
            }
            iArr2[i25] = iArr[i25] < i18 / (i5 * i8) ? i : 0;
            if (iArr[i25] == i18 / i4) {
                iArr[i25] = 0;
            }
            i24 = i25 + 1;
        }
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i21, i22);
        for (int i26 = -(i19 / 2); i26 <= i19 / 2; i26++) {
            dArr2[((i19 / 2) + i26) % i21][((i19 / 2) + i26) / i21] = ((a(i26, i19, k, i20) * c(i26, d7, i18)) * i18) / i4;
        }
        double d8 = this.hFH;
        if (d8 <= 21.0d) {
            d3 = 0.9222d;
        } else {
            d3 = (d8 - 7.95d) / 14.36d;
        }
        int i27 = i5 * i8;
        int i28 = 1;
        while (true) {
            i9 = i17 * i28;
            if (i9 % 2 == 0) {
                i9--;
            }
            d4 = i4 / 2;
            if ((i27 * d3) / (i9 - 1) < this.hFI) {
                break;
            }
            i28 *= 2;
        }
        double k2 = k(d8);
        double i29 = f.i(k2);
        int i30 = 1;
        while (i30 < i9) {
            i30 *= 2;
        }
        int i31 = i30 * 2;
        double[] dArr3 = new double[i31];
        int i32 = -(i9 / 2);
        while (i32 <= i9 / 2) {
            dArr3[(i9 / 2) + i32] = ((a(i32, i9, k2, i29) * c(i32, d4, i27)) / i31) * 2.0d;
            i32++;
        }
        int[] iArr3 = new int[(int) (2.0d + Math.sqrt(i31))];
        iArr3[0] = 0;
        double[] dArr4 = new double[i31 / 2];
        this.hFG.a(i31, 1, dArr3, iArr3, dArr4);
        bJN();
        int i33 = i31 / 2;
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, i, (i33 / i8) + 1);
        double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, i, i31);
        ByteBuffer allocate = ByteBuffer.allocate((i33 + i22 + 2) * i * i2);
        ByteBuffer allocate2 = ByteBuffer.allocate(((i33 / i8) + 1) * i * i3);
        double[] dArr7 = new double[(i33 + i22 + 2) * i];
        double[] dArr8 = new double[((i33 / i8) + 1) * i];
        int i34 = ((i19 / 2) / (i18 / i4)) + 1;
        int i35 = 0;
        int i36 = (int) ((i9 / 2.0d) / (i27 / i5));
        boolean z3 = true;
        int i37 = i34;
        int i38 = 0;
        int i39 = 0;
        ByteBuffer byteBuffer = allocate;
        int i40 = 0;
        int i41 = 0;
        int i42 = 0;
        while (true) {
            int ceil = (int) (((Math.ceil((i33 * i4) / (i5 * i8)) + 1.0d) + i22) - i37);
            int i43 = ceil + i35 > i6 ? i6 - i35 : ceil;
            byteBuffer.position(0);
            byteBuffer.limit(i43 * i2 * i);
            byte[] bArr = new byte[byteBuffer.limit()];
            int read = inputStream.read(bArr);
            if (read < 0) {
                read = 0;
            }
            if (read < byteBuffer.limit()) {
                i6 = i35 + ((read / i2) * i);
            }
            byteBuffer.limit(read);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.position(read);
            wrap.flip();
            int i44 = read / (i2 * i);
            switch (i2) {
                case 1:
                    i10 = 0;
                    while (i10 < i44 * i) {
                        dArr7[(i * i37) + i10] = 0.007874015748031496d * (wrap.get(i10) - 128.0d);
                        i10++;
                    }
                    break;
                case 2:
                    i10 = 0;
                    while (i10 < i44 * i) {
                        dArr7[(i * i37) + i10] = 3.051850947599719E-5d * wrap.order(this.hFF).asShortBuffer().get(i10);
                        i10++;
                    }
                    break;
                case 3:
                    i10 = 0;
                    while (i10 < i44 * i) {
                        dArr7[(i * i37) + i10] = 1.1920930376163766E-7d * ((wrap.get(i10 * 3) << 0) | (wrap.get((i10 * 3) + 1) << 8) | (wrap.get((i10 * 3) + 2) << 16));
                        i10++;
                    }
                    break;
                case 4:
                    i10 = 0;
                    while (i10 < i44 * i) {
                        dArr7[(i * i37) + i10] = 4.656612875245797E-10d * wrap.order(this.hFF).asIntBuffer().get(i10);
                        i10++;
                    }
                    break;
                default:
                    i10 = i32;
                    break;
            }
            while (i10 < i * ceil) {
                dArr7[(i * i37) + i10] = 0.0d;
                i10++;
            }
            int i45 = i37 + ceil;
            int i46 = i44 + i35;
            boolean z4 = i46 >= i6;
            int i47 = ((((i41 - 1) * i4) + i18) / i18) * i;
            int i48 = 0;
            int i49 = i40;
            int i50 = i38;
            int i51 = i10;
            int i52 = i39;
            while (i48 < i) {
                int i53 = i21 * i8;
                int i54 = i47 + i48;
                switch (i22) {
                    case 7:
                        i15 = i40;
                        for (int i55 = 0; i55 < i33; i55++) {
                            int i56 = iArr[i15];
                            dArr6[i48][i55] = (dArr2[i56][0] * dArr7[(i * 0) + i54]) + (dArr2[i56][1] * dArr7[(i * 1) + i54]) + (dArr2[i56][2] * dArr7[(i * 2) + i54]) + (dArr2[i56][3] * dArr7[(i * 3) + i54]) + (dArr2[i56][4] * dArr7[(i * 4) + i54]) + (dArr2[i56][5] * dArr7[(i * 5) + i54]) + (dArr2[i56][6] * dArr7[(i * 6) + i54]);
                            i54 += iArr2[i15];
                            i15++;
                            if (i15 == i53) {
                                i15 = 0;
                            }
                        }
                        break;
                    case 8:
                    default:
                        i15 = i40;
                        for (int i57 = 0; i57 < i33; i57++) {
                            double d9 = 0.0d;
                            int i58 = iArr[i15];
                            int i59 = i54;
                            for (int i60 = 0; i60 < i22; i60++) {
                                d9 += dArr2[i58][i60] * dArr7[i59];
                                i59 += i;
                            }
                            dArr6[i48][i57] = d9;
                            i54 += iArr2[i15];
                            i15++;
                            if (i15 == i53) {
                                i15 = 0;
                            }
                        }
                        break;
                    case 9:
                        i15 = i40;
                        for (int i61 = 0; i61 < i33; i61++) {
                            int i62 = iArr[i15];
                            dArr6[i48][i61] = (dArr2[i62][0] * dArr7[(i * 0) + i54]) + (dArr2[i62][1] * dArr7[(i * 1) + i54]) + (dArr2[i62][2] * dArr7[(i * 2) + i54]) + (dArr2[i62][3] * dArr7[(i * 3) + i54]) + (dArr2[i62][4] * dArr7[(i * 4) + i54]) + (dArr2[i62][5] * dArr7[(i * 5) + i54]) + (dArr2[i62][6] * dArr7[(i * 6) + i54]) + (dArr2[i62][7] * dArr7[(i * 7) + i54]) + (dArr2[i62][8] * dArr7[(i * 8) + i54]);
                            i54 += iArr2[i15];
                            i15++;
                            if (i15 == i53) {
                                i15 = 0;
                            }
                        }
                        break;
                }
                for (int i63 = i33; i63 < i31; i63++) {
                    dArr6[i48][i63] = 0.0d;
                }
                this.hFG.a(i31, 1, dArr6[i48], iArr3, dArr4);
                dArr6[i48][0] = dArr3[0] * dArr6[i48][0];
                dArr6[i48][1] = dArr3[1] * dArr6[i48][1];
                for (int i64 = 1; i64 < i31 / 2; i64++) {
                    dArr6[i48][i64 * 2] = (dArr3[i64 * 2] * dArr6[i48][i64 * 2]) - (dArr3[(i64 * 2) + 1] * dArr6[i48][(i64 * 2) + 1]);
                    dArr6[i48][(i64 * 2) + 1] = (dArr3[(i64 * 2) + 1] * dArr6[i48][i64 * 2]) + (dArr3[i64 * 2] * dArr6[i48][(i64 * 2) + 1]);
                }
                this.hFG.a(i31, -1, dArr6[i48], iArr3, dArr4);
                int i65 = 0;
                int i66 = i39;
                while (i66 < i33) {
                    dArr8[(i65 * i) + i48] = dArr5[i48][i65] + dArr6[i48][i66];
                    i66 += i8;
                    i65++;
                }
                int i67 = i66 - i33;
                int i68 = 0;
                while (i66 < i31) {
                    dArr5[i48][i68] = dArr6[i48][i66];
                    i66 += i8;
                    i68++;
                }
                i48++;
                i50 = i65;
                i52 = i67;
                i49 = i15;
                i51 = i66;
            }
            int i69 = i41 + (((i4 / gcd) * i33) / i8);
            allocate2.clear();
            if (z) {
                i11 = 0;
                while (i11 < i50 * i) {
                    double d10 = dArr8[i11] > 0.0d ? dArr8[i11] : -dArr8[i11];
                    if (dArr[0] >= d10) {
                        d10 = dArr[0];
                    }
                    dArr[0] = d10;
                    allocate2.asDoubleBuffer().put(i11, dArr8[i11]);
                    i11++;
                }
            } else {
                switch (i3) {
                    case 1:
                        double d11 = d * 127.0d;
                        int i70 = 0;
                        int i71 = 0;
                        while (i71 < i50 * i) {
                            if (i7 != 0) {
                                j3 = a(dArr8[i71] * d11, dArr, i7, i70);
                            } else {
                                j3 = j(dArr8[i71] * d11);
                                if (j3 < -128) {
                                    double d12 = j3 / (-128.0d);
                                    if (dArr[0] >= d12) {
                                        d12 = dArr[0];
                                    }
                                    dArr[0] = d12;
                                    j3 = -128;
                                }
                                if (127 < j3) {
                                    double d13 = j3 / 127.0d;
                                    if (dArr[0] >= d13) {
                                        d13 = dArr[0];
                                    }
                                    dArr[0] = d13;
                                    j3 = 127;
                                }
                            }
                            allocate2.put(i71, (byte) (j3 + 128));
                            int i72 = i70 + 1;
                            if (i72 == i) {
                                i72 = 0;
                            }
                            i71++;
                            i70 = i72;
                        }
                        i11 = i71;
                        break;
                    case 2:
                        double d14 = d * 32767.0d;
                        int i73 = 0;
                        int i74 = 0;
                        while (i74 < i50 * i) {
                            if (i7 != 0) {
                                j2 = a(dArr8[i74] * d14, dArr, i7, i73);
                            } else {
                                j2 = j(dArr8[i74] * d14);
                                if (j2 < -32768) {
                                    double d15 = j2 / (-32768.0d);
                                    if (dArr[0] >= d15) {
                                        d15 = dArr[0];
                                    }
                                    dArr[0] = d15;
                                    j2 = -32768;
                                }
                                if (32767 < j2) {
                                    double d16 = j2 / 32767.0d;
                                    if (dArr[0] >= d16) {
                                        d16 = dArr[0];
                                    }
                                    dArr[0] = d16;
                                    j2 = 32767;
                                }
                            }
                            allocate2.order(this.hFF).asShortBuffer().put(i74, (short) j2);
                            int i75 = i73 + 1;
                            if (i75 == i) {
                                i75 = 0;
                            }
                            i74++;
                            i73 = i75;
                        }
                        i11 = i74;
                        break;
                    case 3:
                        double d17 = d * 8388607.0d;
                        int i76 = 0;
                        int i77 = 0;
                        while (i77 < i50 * i) {
                            if (i7 != 0) {
                                j = a(dArr8[i77] * d17, dArr, i7, i76);
                            } else {
                                j = j(dArr8[i77] * d17);
                                if (j < -8388608) {
                                    double d18 = j / (-8388608.0d);
                                    if (dArr[0] >= d18) {
                                        d18 = dArr[0];
                                    }
                                    dArr[0] = d18;
                                    j = -8388608;
                                }
                                if (8388607 < j) {
                                    double d19 = j / 8388607.0d;
                                    if (dArr[0] >= d19) {
                                        d19 = dArr[0];
                                    }
                                    dArr[0] = d19;
                                    j = 8388607;
                                }
                            }
                            allocate2.put(i77 * 3, (byte) (j & 255));
                            int i78 = j >> 8;
                            allocate2.put((i77 * 3) + 1, (byte) (i78 & 255));
                            allocate2.put((i77 * 3) + 2, (byte) ((i78 >> 8) & 255));
                            int i79 = i76 + 1;
                            if (i79 == i) {
                                i79 = 0;
                            }
                            i77++;
                            i76 = i79;
                        }
                        i11 = i77;
                        break;
                    default:
                        i11 = i51;
                        break;
                }
            }
            if (!z3) {
                if (z4) {
                    if (((i46 * i5) / i4) + 2.0d > i42 + i50) {
                        allocate2.position(0);
                        allocate2.limit(i3 * i * i50);
                        a(outputStream, allocate2);
                        i12 = i42 + i50;
                        i13 = i36;
                        z2 = z3;
                    } else {
                        allocate2.position(0);
                        int floor = (int) (i3 * i * ((Math.floor((i46 * i5) / i4) + 2.0d) - i42));
                        if (floor > 0) {
                            allocate2.limit(floor);
                            a(outputStream, allocate2);
                        }
                    }
                } else {
                    allocate2.position(0);
                    allocate2.limit(i3 * i * i50);
                    a(outputStream, allocate2);
                    i12 = i42 + i50;
                    i13 = i36;
                    z2 = z3;
                }
                i14 = (i69 - 1) / (i18 / i4);
                if ($assertionsDisabled && i45 < i14) {
                    throw new AssertionError();
                }
                System.arraycopy(dArr7, i * i14, dArr7, 0, (i45 - i14) * i);
                int i80 = i45 - i14;
                int i81 = i69 - (i14 * (i18 / i4));
                int i82 = i16 + 1;
                if ((i16 & 7) != 7) {
                    m(i46 / i6);
                }
                i42 = i12;
                z3 = z2;
                i16 = i82;
                i36 = i13;
                i35 = i46;
                i40 = i49;
                i37 = i80;
                i32 = i11;
                i41 = i81;
                i39 = i52;
                i38 = i50;
                byteBuffer = wrap;
            } else {
                if (i50 < i36) {
                    i13 = i36 - i50;
                    i12 = i42;
                    z2 = z3;
                } else if (z4) {
                    if (((i46 * i5) / i4) + 2.0d > (i42 + i50) - i36) {
                        allocate2.position(i3 * i * i36);
                        allocate2.limit(i3 * i * i50);
                        a(outputStream, allocate2);
                        i12 = i42 + (i50 - i36);
                        i13 = i36;
                        z2 = z3;
                    } else {
                        allocate2.position(i3 * i * i36);
                        allocate2.limit((int) (i3 * i * ((Math.floor((i46 * i5) / i4) + 2.0d) - i42)));
                        a(outputStream, allocate2);
                    }
                } else {
                    allocate2.position(i3 * i * i36);
                    allocate2.limit(i3 * i * i50);
                    a(outputStream, allocate2);
                    i12 = i42 + (i50 - i36);
                    i13 = i36;
                    z2 = false;
                }
                i14 = (i69 - 1) / (i18 / i4);
                if ($assertionsDisabled) {
                }
                System.arraycopy(dArr7, i * i14, dArr7, 0, (i45 - i14) * i);
                int i802 = i45 - i14;
                int i812 = i69 - (i14 * (i18 / i4));
                int i822 = i16 + 1;
                if ((i16 & 7) != 7) {
                }
                i42 = i12;
                z3 = z2;
                i16 = i822;
                i36 = i13;
                i35 = i46;
                i40 = i49;
                i37 = i802;
                i32 = i11;
                i41 = i812;
                i39 = i52;
                i38 = i50;
                byteBuffer = wrap;
            }
        }
        m(1.0d);
        return dArr[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:251:0x08a4, code lost:
        m(1.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x08ae, code lost:
        return r0[0];
     */
    /* JADX WARN: Removed duplicated region for block: B:178:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x06d2 A[LOOP:18: B:180:0x06ce->B:182:0x06d2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0979 A[LOOP:19: B:263:0x0975->B:265:0x0979, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0997  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x09aa A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double b(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, double d, int i6, boolean z, int i7) throws IOException {
        int i8;
        double d2;
        int i9;
        double d3;
        double d4;
        int[] iArr;
        int[] iArr2;
        int i10;
        double[][] dArr;
        int i11;
        int i12;
        int i13;
        int i14;
        int j;
        int j2;
        int j3;
        boolean z2;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        double[] dArr2 = {0.0d};
        int i20 = this.hFJ;
        double d5 = this.hFH;
        int gcd = gcd(i4, i5);
        if (i5 / gcd == 1) {
            i8 = 1;
        } else if ((i5 / gcd) % 2 == 0) {
            i8 = 2;
        } else if ((i5 / gcd) % 3 == 0) {
            i8 = 3;
        } else {
            throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i5 / gcd)));
        }
        int i21 = i4 * i8;
        if (d5 <= 21.0d) {
            d2 = 0.9222d;
        } else {
            d2 = (d5 - 7.95d) / 14.36d;
        }
        int i22 = 1;
        while (true) {
            i9 = i20 * i22;
            if (i9 % 2 == 0) {
                i9--;
            }
            double d6 = (i21 * d2) / (i9 - 1);
            d3 = (i5 - d6) / 2.0d;
            if (d6 < this.hFI) {
                break;
            }
            i22 *= 2;
        }
        double k = k(d5);
        double i23 = f.i(k);
        int i24 = 1;
        while (i24 < i9) {
            i24 *= 2;
        }
        int i25 = i24 * 2;
        double[] dArr3 = new double[i25];
        int i26 = -(i9 / 2);
        while (i26 <= i9 / 2) {
            dArr3[i26 + (i9 / 2)] = ((((a(i26, i9, k, i23) * c(i26, d3, i21)) * i21) / i4) / i25) * 2.0d;
            i26++;
        }
        int[] iArr3 = new int[(int) (2.0d + Math.sqrt(i25))];
        iArr3[0] = 0;
        double[] dArr4 = new double[i25 / 2];
        this.hFG.a(i25, 1, dArr3, iArr3, dArr4);
        if (i8 == 1) {
            int i27 = (i4 / gcd) * i5;
            double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, 1, 1);
            dArr5[0][0] = 1.0d;
            iArr = new int[]{i4 / i5};
            iArr2 = new int[]{0};
            i12 = 1;
            i10 = 1;
            dArr = dArr5;
            i11 = i27;
            i13 = 1;
        } else {
            double d7 = this.hFH;
            int i28 = (i4 / gcd) * i5;
            double d8 = (((i21 / 2) - (i4 / 2)) * 2) / 2.0d;
            double d9 = (i4 / 2) + (((i21 / 2) - (i4 / 2)) / 2.0d);
            if (d7 <= 21.0d) {
                d4 = 0.9222d;
            } else {
                d4 = (d7 - 7.95d) / 14.36d;
            }
            int i29 = (int) ((d4 * (i28 / d8)) + 1.0d);
            if (i29 % 2 == 0) {
                i29++;
            }
            double k2 = k(d7);
            double i30 = f.i(k2);
            int i31 = i28 / i21;
            int i32 = (i29 / i31) + 1;
            int[] iArr4 = new int[i31];
            for (int i33 = 0; i33 < i31; i33++) {
                iArr4[i33] = (i28 / i21) - (((i28 / i5) * i33) % (i28 / i21));
                if (iArr4[i33] == i28 / i21) {
                    iArr4[i33] = 0;
                }
            }
            int[] iArr5 = new int[i31];
            int i34 = 0;
            while (true) {
                int i35 = i34;
                if (i35 >= i31) {
                    break;
                }
                iArr5[i35] = (((i28 / i5) - iArr4[i35]) / (i28 / i21)) + 1;
                if (iArr4[i35 + 1 == i31 ? 0 : i35 + 1] == 0) {
                    iArr5[i35] = iArr5[i35] - 1;
                }
                i34 = i35 + 1;
            }
            double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, i31, i32);
            int i36 = -(i29 / 2);
            while (i36 <= i29 / 2) {
                dArr6[((i29 / 2) + i36) % i31][((i29 / 2) + i36) / i31] = ((a(i36, i29, k2, i30) * c(i36, d9, i28)) * i28) / i21;
                i36++;
            }
            i26 = i36;
            iArr = iArr5;
            iArr2 = iArr4;
            i10 = i32;
            dArr = dArr6;
            i11 = i28;
            i12 = i31;
            i13 = i29;
        }
        bJN();
        int i37 = i25 / 2;
        double[][] dArr7 = (double[][]) Array.newInstance(Double.TYPE, i, i25);
        double[][] dArr8 = (double[][]) Array.newInstance(Double.TYPE, i, i10 + 1 + i37);
        ByteBuffer allocate = ByteBuffer.allocate(((i37 / i8) + i8 + 1) * i * i2);
        ByteBuffer allocate2 = ByteBuffer.allocate((int) ((((i37 * i5) / i4) + 1.0d) * i3 * i));
        double[] dArr9 = new double[((i37 / i8) + i8 + 1) * i];
        double[] dArr10 = new double[(int) (i * (((i37 * i5) / i4) + 1.0d))];
        int i38 = 0;
        int i39 = 0;
        boolean z3 = true;
        int i40 = (int) (((i13 / 2.0d) / (i11 / i5)) + ((i9 / 2.0d) / (i21 / i5)));
        int i41 = 0;
        int i42 = 0;
        int i43 = 0;
        int i44 = 0;
        int i45 = i26;
        ByteBuffer byteBuffer = allocate;
        int i46 = i40;
        int i47 = 0;
        while (true) {
            int i48 = (((i37 - 0) - 1) / i8) + 1;
            if (i48 + i47 > i6) {
                i48 = i6 - i47;
            }
            byteBuffer.position(0);
            byteBuffer.limit(i2 * i * i48);
            byte[] bArr = new byte[byteBuffer.limit()];
            int read = inputStream.read(bArr);
            if (read < 0) {
                read = 0;
            }
            if (read < byteBuffer.limit()) {
                i6 = i47 + ((read / i2) * i);
            }
            byteBuffer.limit(read);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.position(read);
            wrap.flip();
            int i49 = read / (i2 * i);
            switch (i2) {
                case 1:
                    i45 = 0;
                    while (i45 < i49 * i) {
                        dArr9[(i * 0) + i45] = 0.007874015748031496d * ((wrap.get(i45) & 255) - 128);
                        i45++;
                    }
                    break;
                case 2:
                    i45 = 0;
                    while (i45 < i49 * i) {
                        dArr9[(i * 0) + i45] = 3.051850947599719E-5d * wrap.order(this.hFF).asShortBuffer().get(i45);
                        i45++;
                    }
                    break;
                case 3:
                    i45 = 0;
                    while (i45 < i49 * i) {
                        dArr9[(i * 0) + i45] = 1.1920930376163766E-7d * (((wrap.get(i45 * 3) & 255) << 0) | ((wrap.get((i45 * 3) + 1) & 255) << 8) | ((wrap.get((i45 * 3) + 2) & 255) << 16));
                        i45++;
                    }
                    break;
                case 4:
                    i45 = 0;
                    while (i45 < i49 * i) {
                        dArr9[(i * 0) + i45] = 4.656612875245797E-10d * wrap.order(this.hFF).getInt(i45);
                        i45++;
                    }
                    break;
            }
            while (i45 < i * i48) {
                dArr9[i45] = 0.0d;
                i45++;
            }
            int i50 = i47 + i49;
            boolean z4 = inputStream.available() < 0 || i50 >= i6;
            int i51 = 0;
            int i52 = i38;
            int i53 = i42;
            int i54 = i43;
            while (true) {
                int i55 = i45;
                if (i51 < i) {
                    int i56 = 0;
                    int i57 = 0;
                    while (i57 < i37) {
                        if (!$assertionsDisabled && i56 >= (((i37 - 0) - 1) / i8) + 1) {
                            throw new AssertionError();
                        }
                        dArr7[i51][i57] = dArr9[(i56 * i) + i51];
                        for (int i58 = i57 + 1; i58 < i57 + i8; i58++) {
                            dArr7[i51][i58] = 0.0d;
                        }
                        i57 += i8;
                        i56++;
                    }
                    if (!$assertionsDisabled && i56 != (((i37 - 0) - 1) / i8) + 1) {
                        throw new AssertionError();
                    }
                    for (int i59 = i37; i59 < i25; i59++) {
                        dArr7[i51][i59] = 0.0d;
                    }
                    int i60 = i57 - i37;
                    int i61 = i54 + i56;
                    this.hFG.a(i25, 1, dArr7[i51], iArr3, dArr4);
                    dArr7[i51][0] = dArr3[0] * dArr7[i51][0];
                    dArr7[i51][1] = dArr3[1] * dArr7[i51][1];
                    for (int i62 = 1; i62 < i37; i62++) {
                        double d10 = (dArr3[i62 * 2] * dArr7[i51][i62 * 2]) - (dArr3[(i62 * 2) + 1] * dArr7[i51][(i62 * 2) + 1]);
                        double d11 = (dArr3[(i62 * 2) + 1] * dArr7[i51][i62 * 2]) + (dArr3[i62 * 2] * dArr7[i51][(i62 * 2) + 1]);
                        dArr7[i51][i62 * 2] = d10;
                        dArr7[i51][(i62 * 2) + 1] = d11;
                    }
                    this.hFG.a(i25, -1, dArr7[i51], iArr3, dArr4);
                    int i63 = 0;
                    while (i63 < i37) {
                        double[] dArr11 = dArr8[i51];
                        int i64 = i10 + 1 + i63;
                        dArr11[i64] = dArr11[i64] + dArr7[i51][i63];
                        i63++;
                    }
                    int i65 = i39 / (i11 / i21);
                    if (i39 % (i11 / i21) != 0) {
                        i65++;
                    }
                    i45 = i63;
                    int length = (dArr8[0].length * i51) + i65;
                    int i66 = 0;
                    int i67 = i38;
                    while (length - (dArr8[0].length * i51) < i37 + 1) {
                        int i68 = iArr2[i67];
                        int i69 = iArr[i67] + length;
                        i67++;
                        if (i67 == i12) {
                            i67 = 0;
                        }
                        if (!$assertionsDisabled && ((length - (dArr8[0].length * i51)) * (i11 / i21)) - (((i11 / i5) * i66) + i39) != i68) {
                            throw new AssertionError();
                        }
                        int i70 = length;
                        int i71 = 0;
                        double d12 = 0.0d;
                        int i72 = i70;
                        while (i71 < i10) {
                            d12 += dArr[i68][i71] * dArr8[i72 / dArr8[0].length][i72 % dArr8[0].length];
                            i72++;
                            i71++;
                        }
                        dArr10[(i66 * i) + 0 + i51] = d12;
                        i66++;
                        i45 = i71;
                        length = i69;
                    }
                    i51++;
                    i52 = i67;
                    i53 = i66;
                    i54 = i61;
                } else {
                    int i73 = i39 + ((i11 / i5) * i53);
                    allocate2.clear();
                    if (z) {
                        i14 = 0;
                        while (i14 < i53 * i) {
                            double d13 = dArr10[i14] > 0.0d ? dArr10[i14] : -dArr10[i14];
                            if (dArr2[0] >= d13) {
                                d13 = dArr2[0];
                            }
                            dArr2[0] = d13;
                            allocate2.asDoubleBuffer().put(i14, dArr10[i14]);
                            i14++;
                        }
                    } else {
                        switch (i3) {
                            case 1:
                                double d14 = d * 127.0d;
                                int i74 = 0;
                                int i75 = 0;
                                while (i75 < i53 * i) {
                                    if (i7 != 0) {
                                        j3 = a(dArr10[i75] * d14, dArr2, i7, i74);
                                    } else {
                                        j3 = j(dArr10[i75] * d14);
                                        if (j3 < -128) {
                                            double d15 = j3 / (-128.0d);
                                            if (dArr2[0] >= d15) {
                                                d15 = dArr2[0];
                                            }
                                            dArr2[0] = d15;
                                            j3 = -128;
                                        }
                                        if (127 < j3) {
                                            double d16 = j3 / 127.0d;
                                            if (dArr2[0] >= d16) {
                                                d16 = dArr2[0];
                                            }
                                            dArr2[0] = d16;
                                            j3 = 127;
                                        }
                                    }
                                    allocate2.put(i75, (byte) (j3 + 128));
                                    int i76 = i74 + 1;
                                    if (i76 == i) {
                                        i76 = 0;
                                    }
                                    i75++;
                                    i74 = i76;
                                }
                                i14 = i75;
                                break;
                            case 2:
                                double d17 = d * 32767.0d;
                                int i77 = 0;
                                int i78 = 0;
                                while (i78 < i53 * i) {
                                    if (i7 != 0) {
                                        j2 = a(dArr10[i78] * d17, dArr2, i7, i77);
                                    } else {
                                        j2 = j(dArr10[i78] * d17);
                                        if (j2 < -32768) {
                                            double d18 = j2 / (-32768.0d);
                                            if (dArr2[0] >= d18) {
                                                d18 = dArr2[0];
                                            }
                                            dArr2[0] = d18;
                                            j2 = -32768;
                                        }
                                        if (32767 < j2) {
                                            double d19 = j2 / 32767.0d;
                                            if (dArr2[0] >= d19) {
                                                d19 = dArr2[0];
                                            }
                                            dArr2[0] = d19;
                                            j2 = 32767;
                                        }
                                    }
                                    allocate2.order(this.hFF).asShortBuffer().put(i78, (short) j2);
                                    int i79 = i77 + 1;
                                    if (i79 == i) {
                                        i79 = 0;
                                    }
                                    i78++;
                                    i77 = i79;
                                }
                                i14 = i78;
                                break;
                            case 3:
                                double d20 = d * 8388607.0d;
                                int i80 = 0;
                                int i81 = 0;
                                while (i81 < i53 * i) {
                                    if (i7 != 0) {
                                        j = a(dArr10[i81] * d20, dArr2, i7, i80);
                                    } else {
                                        j = j(dArr10[i81] * d20);
                                        if (j < -8388608) {
                                            double d21 = j / (-8388608.0d);
                                            if (dArr2[0] >= d21) {
                                                d21 = dArr2[0];
                                            }
                                            dArr2[0] = d21;
                                            j = -8388608;
                                        }
                                        if (8388607 < j) {
                                            double d22 = j / 8388607.0d;
                                            if (dArr2[0] >= d22) {
                                                d22 = dArr2[0];
                                            }
                                            dArr2[0] = d22;
                                            j = 8388607;
                                        }
                                    }
                                    allocate2.put(i81 * 3, (byte) (j & 255));
                                    int i82 = j >> 8;
                                    allocate2.put((i81 * 3) + 1, (byte) (i82 & 255));
                                    allocate2.put((i81 * 3) + 2, (byte) ((i82 >> 8) & 255));
                                    int i83 = i80 + 1;
                                    if (i83 == i) {
                                        i83 = 0;
                                    }
                                    i81++;
                                    i80 = i83;
                                }
                                i14 = i81;
                                break;
                            default:
                                i14 = i55;
                                break;
                        }
                    }
                    if (!z3) {
                        if (z4) {
                            if (((i50 * i5) / i4) + 2.0d > i41 + i53) {
                                allocate2.position(0);
                                allocate2.limit(i3 * i * i53);
                                a(outputStream, allocate2);
                                i15 = i41 + i53;
                                z2 = z3;
                                i16 = i46;
                            } else {
                                allocate2.position(0);
                                int floor = (int) (i3 * i * ((Math.floor((i50 * i5) / i4) + 2.0d) - i41));
                                if (floor > 0) {
                                    allocate2.limit(floor);
                                    a(outputStream, allocate2);
                                }
                            }
                        } else {
                            allocate2.position(0);
                            allocate2.limit(i3 * i * i53);
                            a(outputStream, allocate2);
                            i15 = i41 + i53;
                            z2 = z3;
                            i16 = i46;
                        }
                        i17 = (i73 - 1) / (i11 / i21);
                        if (i17 > i37) {
                            i17 = i37;
                        }
                        for (i18 = 0; i18 < i; i18++) {
                            System.arraycopy(dArr8[i18], i17, dArr8[i18], 0, ((i10 + 1) + i37) - i17);
                        }
                        int i84 = i73 - (i17 * (i11 / i21));
                        for (i19 = 0; i19 < i; i19++) {
                            System.arraycopy(dArr7[i19], i37, dArr8[i19], i10 + 1, i37);
                        }
                        int i85 = i44 + 1;
                        if ((i44 & 7) != 7) {
                            m(i50 / i6);
                        }
                        i46 = i16;
                        i41 = i15;
                        z3 = z2;
                        i44 = i85;
                        i38 = i52;
                        i42 = i53;
                        i43 = i54;
                        i47 = i50;
                        byteBuffer = wrap;
                        int i86 = i14;
                        i39 = i84;
                        i45 = i86;
                    } else {
                        if (i53 < i46) {
                            i16 = i46 - i53;
                            i15 = i41;
                            z2 = z3;
                        } else if (z4) {
                            if (((i50 * i5) / i4) + 2.0d > (i41 + i53) - i46) {
                                allocate2.position(i3 * i * i46);
                                allocate2.limit(i3 * i * (i53 - i46));
                                a(outputStream, allocate2);
                                i15 = (i53 - i46) + i41;
                                z2 = z3;
                                i16 = i46;
                            } else {
                                allocate2.position(i3 * i * i46);
                                allocate2.limit((int) (i3 * i * ((((Math.floor((i50 * i5) / i4) + 2.0d) + i41) + i53) - i46)));
                                a(outputStream, allocate2);
                            }
                        } else {
                            allocate2.position(i3 * i * i46);
                            allocate2.limit(i3 * i * i53);
                            a(outputStream, allocate2);
                            z2 = false;
                            i15 = (i53 - i46) + i41;
                            i16 = i46;
                        }
                        i17 = (i73 - 1) / (i11 / i21);
                        if (i17 > i37) {
                        }
                        while (i18 < i) {
                        }
                        int i842 = i73 - (i17 * (i11 / i21));
                        while (i19 < i) {
                        }
                        int i852 = i44 + 1;
                        if ((i44 & 7) != 7) {
                        }
                        i46 = i16;
                        i41 = i15;
                        z3 = z2;
                        i44 = i852;
                        i38 = i52;
                        i42 = i53;
                        i43 = i54;
                        i47 = i50;
                        byteBuffer = wrap;
                        int i862 = i14;
                        i39 = i842;
                        i45 = i862;
                    }
                }
            }
        }
    }

    public double a(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, double d, int i4, boolean z, int i5) throws IOException {
        ByteBuffer byteBuffer;
        double[] dArr = {0.0d};
        int i6 = 0;
        bJN();
        ByteBuffer byteBuffer2 = null;
        if (z) {
            byteBuffer2 = ByteBuffer.allocate(8);
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        int i7 = 0;
        while (i7 < i4 * i) {
            double d2 = 0.0d;
            switch (i2) {
                case 1:
                    allocate.position(0);
                    allocate.limit(1);
                    byte[] bArr = new byte[allocate.limit()];
                    inputStream.read(bArr);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    wrap.position(wrap.limit());
                    wrap.flip();
                    d2 = 0.007874015748031496d * (wrap.get(0) - 128);
                    byteBuffer = wrap;
                    break;
                case 2:
                    allocate.position(0);
                    allocate.limit(2);
                    byte[] bArr2 = new byte[allocate.limit()];
                    inputStream.read(bArr2);
                    ByteBuffer wrap2 = ByteBuffer.wrap(bArr2);
                    wrap2.position(wrap2.limit());
                    wrap2.flip();
                    d2 = wrap2.order(this.hFF).asShortBuffer().get(0) * 3.051850947599719E-5d;
                    byteBuffer = wrap2;
                    break;
                case 3:
                    allocate.position(0);
                    allocate.limit(3);
                    byte[] bArr3 = new byte[allocate.limit()];
                    inputStream.read(bArr3);
                    ByteBuffer wrap3 = ByteBuffer.wrap(bArr3);
                    wrap3.position(wrap3.limit());
                    wrap3.flip();
                    d2 = 1.1920930376163766E-7d * (((wrap3.get(0) & 255) << 0) | ((wrap3.get(1) & 255) << 8) | ((wrap3.get(2) & 255) << 16));
                    byteBuffer = wrap3;
                    break;
                case 4:
                    allocate.position(0);
                    allocate.limit(4);
                    byte[] bArr4 = new byte[allocate.limit()];
                    inputStream.read(bArr4);
                    ByteBuffer wrap4 = ByteBuffer.wrap(bArr4);
                    wrap4.position(wrap4.limit());
                    wrap4.flip();
                    d2 = wrap4.order(this.hFF).asIntBuffer().get(0) * 4.656612875245797E-10d;
                    byteBuffer = wrap4;
                    break;
                default:
                    byteBuffer = allocate;
                    break;
            }
            if (inputStream.available() != 0) {
                double d3 = d2 * d;
                if (!z) {
                    switch (i3) {
                        case 1:
                            double d4 = 127.0d * d3;
                            int a = i5 != 0 ? a(d4, dArr, i5, i6) : j(d4);
                            byteBuffer.position(0);
                            byteBuffer.limit(1);
                            byteBuffer.put(0, (byte) (a + 128));
                            byteBuffer.flip();
                            a(outputStream, byteBuffer);
                            break;
                        case 2:
                            double d5 = 32767.0d * d3;
                            int a2 = i5 != 0 ? a(d5, dArr, i5, i6) : j(d5);
                            byteBuffer.position(0);
                            byteBuffer.limit(2);
                            byteBuffer.asShortBuffer().put(0, (short) a2);
                            byteBuffer.flip();
                            a(outputStream, byteBuffer);
                            break;
                        case 3:
                            double d6 = 8388607.0d * d3;
                            int a3 = i5 != 0 ? a(d6, dArr, i5, i6) : j(d6);
                            byteBuffer.position(0);
                            byteBuffer.limit(3);
                            byteBuffer.put(0, (byte) (a3 & 255));
                            int i8 = a3 >> 8;
                            byteBuffer.put(1, (byte) (i8 & 255));
                            byteBuffer.put(2, (byte) ((i8 >> 8) & 255));
                            byteBuffer.flip();
                            a(outputStream, byteBuffer);
                            break;
                    }
                } else {
                    double d7 = d3 > 0.0d ? d3 : -d3;
                    if (dArr[0] >= d7) {
                        d7 = dArr[0];
                    }
                    dArr[0] = d7;
                    byteBuffer2.position(0);
                    byteBuffer2.putDouble(d3);
                    byteBuffer2.flip();
                    a(outputStream, byteBuffer2);
                }
                int i9 = i6 + 1;
                if (i9 == i) {
                    i9 = 0;
                }
                int i10 = i7 + 1;
                if ((262143 & i10) == 0) {
                    m(i10 / (i4 * i));
                }
                i7 = i10;
                i6 = i9;
                allocate = byteBuffer;
            } else {
                m(1.0d);
                return dArr[0];
            }
        }
        m(1.0d);
        return dArr[0];
    }

    public j() {
        this.hFF = ByteOrder.LITTLE_ENDIAN;
        this.hFG = new k();
        this.hFH = 150.0d;
        this.hFI = 200.0d;
        this.hFJ = 1;
        this.hFV = false;
    }

    public j(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, int i6, double d, int i7, boolean z) throws Exception {
        int i8;
        int i9;
        this.hFF = ByteOrder.LITTLE_ENDIAN;
        this.hFG = new k();
        this.hFH = 150.0d;
        this.hFI = 200.0d;
        this.hFJ = 1;
        this.hFV = false;
        double[] dArr = {0.0d};
        if (i7 < 0 || i7 > 4) {
            throw new IllegalArgumentException("unrecognized dither type : " + i7);
        }
        this.hFV = z;
        if (!this.hFV) {
            System.err.printf("Shibatch sampling rate converter version 1.30(high precision/nio)\n\n", new Object[0]);
        }
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            throw new IllegalStateException("Error : Only 8bit, 16bit, 24bit and 32bit PCM are supported.");
        }
        if (i4 == -1) {
            i8 = i3 != 1 ? i3 : 2;
            if (i8 == 4) {
                i8 = 3;
            }
        } else {
            i8 = i4;
        }
        int i10 = i2 == -1 ? i : i2;
        if (i7 != -1) {
            i9 = i7;
        } else if (i8 < i3) {
            if (i8 == 1) {
                i9 = 4;
            } else {
                i9 = 3;
            }
        } else {
            i9 = 1;
        }
        if (!this.hFV) {
            String[] strArr = {"none", "no noise shaping", "triangular spectral shape", "ATH based noise shaping", "ATH based noise shaping(less amplitude)"};
            String[] strArr2 = {"rectangular", "triangular", "gaussian"};
            System.err.printf("frequency : %d -> %d\n", Integer.valueOf(i), Integer.valueOf(i10));
            System.err.printf("attenuation : %gdB\n", Double.valueOf(d));
            System.err.printf("bits per sample : %d -> %d\n", Integer.valueOf(i3 * 8), Integer.valueOf(i8 * 8));
            System.err.printf("nchannels : %d\n", Integer.valueOf(i5));
            System.err.printf("length : %d bytes, %g secs\n", Integer.valueOf(i6), Double.valueOf(((i6 / i3) / i5) / i));
            if (i9 == 0) {
                System.err.printf("dither type : none\n", new Object[0]);
            } else {
                System.err.printf("dither type : %s, %s p.d.f, amp = %g\n", strArr[i9], strArr2[0], Double.valueOf(0.18d));
            }
            System.err.printf("\n", new Object[0]);
        }
        if (i9 != 0) {
            int i11 = 0;
            int i12 = 0;
            if (i8 == 1) {
                i11 = -128;
                i12 = 127;
            }
            if (i8 == 2) {
                i11 = -32768;
                i12 = 32767;
            }
            if (i8 == 3) {
                i11 = -8388608;
                i12 = 8388607;
            }
            if (i8 == 4) {
                i11 = Integer.MIN_VALUE;
                i12 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            a(i10, i5, i11, i12, i9, 0, 0.18d);
        }
        if (i < i10) {
            dArr[0] = a(inputStream, outputStream, i5, i3, i8, i, i10, Math.pow(10.0d, (-d) / 20.0d), (i6 / i3) / i5, false, i9);
        } else if (i > i10) {
            dArr[0] = b(inputStream, outputStream, i5, i3, i8, i, i10, Math.pow(10.0d, (-d) / 20.0d), (i6 / i3) / i5, false, i9);
        } else {
            dArr[0] = a(inputStream, outputStream, i5, i3, i8, Math.pow(10.0d, (-d) / 20.0d), (i6 / i3) / i5, false, i9);
        }
        if (!this.hFV) {
            System.err.printf("\n", new Object[0]);
        }
        if (i9 != 0) {
            wy(i5);
        }
        if (dArr[0] > 1.0d && !this.hFV) {
            System.err.printf("clipping detected : %gdB\n", Double.valueOf(20.0d * Math.log10(dArr[0])));
        }
    }

    protected byte[] j(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.limit() - byteBuffer.position()];
        byteBuffer.get(bArr, 0, bArr.length);
        return bArr;
    }

    protected void a(OutputStream outputStream, ByteBuffer byteBuffer) {
        try {
            outputStream.write(j(byteBuffer));
        } catch (IOException e) {
        }
    }
}
