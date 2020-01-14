package com.baidu.tieba.video.meida;

import com.baidu.ala.player.StreamConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;
/* loaded from: classes8.dex */
public class j {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final double[][] kzA;
    private static final double[] kzM;
    private static final int[] kzx;
    private static final int[] kzy;
    private static final int[] kzz;
    private double[][] kzB;
    private int kzC;
    private int kzD;
    private int kzE;
    private int kzF;
    private double[] kzG;
    private int kzH;
    private boolean kzI;
    private int kzJ;
    private long kzK;
    private long kzL;
    private ByteOrder kzs;
    private k kzt;
    private double kzu;
    private double kzv;
    private int kzw;

    static {
        $assertionsDisabled = !j.class.desiredAssertionStatus();
        kzx = new int[]{0, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, StreamConfig.Audio.AUDIO_FREQUENCY, 37800, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_32K, 22050, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, StreamConfig.Audio.AUDIO_FREQUENCY};
        kzy = new int[]{1, 16, 20, 16, 16, 15, 16, 15};
        kzz = new int[]{8, 18, 27, 8, 8, 8, 10, 9};
        kzA = new double[][]{new double[]{-1.0d}, new double[]{-2.87207293510437d, 5.041323184967041d, -6.244299411773682d, 5.848398685455322d, -3.706754207611084d, 1.0495119094848633d, 1.1830236911773682d, -2.1126792430877686d, 1.9094531536102295d, -0.9991308450698853d, 0.17090806365013123d, 0.32615602016448975d, -0.39127644896507263d, 0.2687646150588989d, -0.0976761057972908d, 0.023473845794796944d}, new double[]{-2.6773197650909424d, 4.830892562866211d, -6.570110321044922d, 7.4572014808654785d, -6.726327419281006d, 4.848165035247803d, -2.0412089824676514d, -0.7006359100341797d, 2.95375657081604d, -4.080038547515869d, 4.184521675109863d, -3.331181287765503d, 2.117992639541626d, -0.879302978515625d, 0.031759146600961685d, 0.4238278865814209d, -0.4788210391998291d, 0.35490813851356506d, -0.1749683916568756d, 0.06090816855430603d}, new double[]{-1.6335992813110352d, 2.261549234390259d, -2.407702922821045d, 2.634171724319458d, -2.144036293029785d, 1.8153258562088013d, -1.0816224813461304d, 0.703026533126831d, -0.15991993248462677d, -0.04154951870441437d, 0.2941657602787018d, -0.25183168053627014d, 0.27766478061676025d, -0.15785403549671173d, 0.10165894031524658d, -0.016833892092108727d}, new double[]{-0.8290129899978638d, 0.9892265796661377d, -0.5982571244239807d, 1.0028809309005737d, -0.5993821620941162d, 0.7950245141983032d, -0.42723315954208374d, 0.5449252724647522d, -0.3079260587692261d, 0.3687179982662201d, -0.187920480966568d, 0.2261127084493637d, -0.10573341697454453d, 0.11435490846633911d, -0.0388006791472435d, 0.040842197835445404d}, new double[]{-0.06522997468709946d, 0.5498126149177551d, 0.4027854800224304d, 0.3178376853466034d, 0.2820179760456085d, 0.16985194385051727d, 0.15433363616466522d, 0.12507140636444092d, 0.08903945237398148d, 0.06441012024879456d, 0.04714600369334221d, 0.03280523791909218d, 0.028495194390416145d, 0.011695005930960178d, 0.011831838637590408d}, new double[]{-2.3925774097442627d, 3.4350297451019287d, -3.185370922088623d, 1.8117271661758423d, 0.2012477070093155d, -1.4759907722473145d, 1.7210904359817505d, -0.9774670004844666d, 0.13790138065814972d, 0.38185903429985046d, -0.27421241998672485d, -0.06658421456813812d, 0.35223302245140076d, -0.37672343850135803d, 0.23964276909828186d, -0.06867482513189316d}, new double[]{-2.0833916664123535d, 3.0418450832366943d, -3.204789876937866d, 2.757192611694336d, -1.4978630542755127d, 0.34275946021080017d, 0.7173374891281128d, -1.073705792427063d, 1.0225815773010254d, -0.5664999485015869d, 0.20968692004680634d, 0.06537853181362152d, -0.10322438180446625d, 0.06744202226400375d, 0.00495197344571352d}};
        kzM = new double[]{0.7d, 0.9d, 0.18d};
    }

    private int n(double d) {
        return d >= 0.0d ? (int) (d + 0.5d) : (int) (d - 0.5d);
    }

    public int a(int i, int i2, int i3, int i4, int i5, int i6, double d) {
        int[] iArr = new int[97];
        int i7 = 1;
        while (i7 < 6 && i != kzx[i7]) {
            i7++;
        }
        if ((i5 == 3 || i5 == 4) && i7 == 6) {
            System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", Integer.valueOf(i));
        }
        i7 = (i5 == 2 || i7 == 6) ? 0 : 0;
        if (i5 == 4 && (i7 == 1 || i7 == 2)) {
            i7 += 5;
        }
        this.kzC = i7;
        this.kzB = new double[i2];
        this.kzD = kzy[this.kzC];
        for (int i8 = 0; i8 < i2; i8++) {
            this.kzB[i8] = new double[this.kzD];
        }
        this.kzE = i3;
        this.kzF = i4;
        this.kzG = new double[65536];
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
                    this.kzG[i10] = ((i11 / 2.147483647E9d) - 0.5d) * d;
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
                    this.kzG[i12] = ((i13 / 2.147483647E9d) - (i14 / 2.147483647E9d)) * d;
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
                        this.kzG[i15] = d * d2 * Math.cos(d3);
                    } else {
                        z = false;
                        this.kzG[i15] = d * d2 * Math.sin(d3);
                    }
                }
                break;
        }
        this.kzH = 0;
        if (i5 == 0 || i5 == 1) {
            return 1;
        }
        return kzz[this.kzC];
    }

    public int a(double d, double[] dArr, int i, int i2) {
        double n;
        if (i == 1) {
            double[] dArr2 = this.kzG;
            int i3 = this.kzH;
            this.kzH = i3 + 1;
            double d2 = dArr2[i3 & 65535] + d;
            if (d2 < this.kzE) {
                double d3 = d2 / this.kzE;
                if (dArr[0] >= d3) {
                    d3 = dArr[0];
                }
                dArr[0] = d3;
                d2 = this.kzE;
            }
            if (d2 > this.kzF) {
                double d4 = d2 / this.kzF;
                if (dArr[0] >= d4) {
                    d4 = dArr[0];
                }
                dArr[0] = d4;
                d2 = this.kzF;
            }
            return n(d2);
        }
        double d5 = 0.0d;
        for (int i4 = 0; i4 < this.kzD; i4++) {
            d5 += kzA[this.kzC][i4] * this.kzB[i2][i4];
        }
        double d6 = d5 + d;
        double[] dArr3 = this.kzG;
        int i5 = this.kzH;
        this.kzH = i5 + 1;
        double d7 = d6 + dArr3[i5 & 65535];
        for (int i6 = this.kzD - 2; i6 >= 0; i6--) {
            this.kzB[i2][i6 + 1] = this.kzB[i2][i6];
        }
        if (d7 < this.kzE) {
            double d8 = d7 / this.kzE;
            if (dArr[0] >= d8) {
                d8 = dArr[0];
            }
            dArr[0] = d8;
            n = this.kzE;
            this.kzB[i2][0] = n - d6;
            if (this.kzB[i2][0] > 1.0d) {
                this.kzB[i2][0] = 1.0d;
            }
            if (this.kzB[i2][0] < -1.0d) {
                this.kzB[i2][0] = -1.0d;
            }
        } else if (d7 > this.kzF) {
            double d9 = d7 / this.kzF;
            if (dArr[0] >= d9) {
                d9 = dArr[0];
            }
            dArr[0] = d9;
            n = this.kzF;
            this.kzB[i2][0] = n - d6;
            if (this.kzB[i2][0] > 1.0d) {
                this.kzB[i2][0] = 1.0d;
            }
            if (this.kzB[i2][0] < -1.0d) {
                this.kzB[i2][0] = -1.0d;
            }
        } else {
            n = n(d7);
            this.kzB[i2][0] = n - d6;
        }
        return (int) n;
    }

    private void Dx(int i) {
    }

    private double o(double d) {
        if (d <= 21.0d) {
            return 0.0d;
        }
        if (d <= 50.0d) {
            return (0.5842d * Math.pow(d - 21.0d, 0.4d)) + (0.07886d * (d - 21.0d));
        }
        return 0.1102d * (d - 8.7d);
    }

    private double a(double d, int i, double d2, double d3) {
        return f.m(Math.sqrt(1.0d - (((4.0d * d) * d) / ((i - 1.0d) * (i - 1.0d)))) * d2) / d3;
    }

    private double p(double d) {
        if (d == 0.0d) {
            return 1.0d;
        }
        return Math.sin(d) / d;
    }

    private double a(int i, double d, double d2) {
        double d3 = 1.0d / d2;
        return p(d3 * 6.283185307179586d * d * i) * 2.0d * d * d3;
    }

    private void cPA() {
        this.kzK = System.currentTimeMillis();
        this.kzL = 0L;
        this.kzJ = -1;
    }

    private void q(double d) {
        if (!this.kzI) {
            long currentTimeMillis = System.currentTimeMillis() - this.kzK;
            int i = d == 0.0d ? 0 : (int) ((currentTimeMillis * (1.0d - d)) / d);
            int i2 = (int) (100.0d * d);
            if (i2 != this.kzJ || currentTimeMillis != this.kzL) {
                System.err.printf(" %3d%% processed", Integer.valueOf(i2));
                this.kzJ = i2;
            }
            if (currentTimeMillis != this.kzL) {
                System.err.printf(", ETA =%4dmsec", Integer.valueOf(i));
                this.kzL = currentTimeMillis;
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
        int n;
        int n2;
        int n3;
        int i12;
        int i13;
        boolean z2;
        int i14;
        int i15;
        double[] dArr = {0.0d};
        int i16 = 0;
        int i17 = this.kzw;
        double d5 = this.kzu;
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
        double o = o(d5);
        double m = f.m(o);
        int i20 = i18 / i4;
        int i21 = (i19 / i20) + 1;
        int[] iArr = new int[i20 * i8];
        for (int i22 = 0; i22 < i20 * i8; i22++) {
            iArr[i22] = (i18 / i4) - (((i18 / (i5 * i8)) * i22) % (i18 / i4));
            if (iArr[i22] == i18 / i4) {
                iArr[i22] = 0;
            }
        }
        int[] iArr2 = new int[i20 * i8];
        int i23 = 0;
        while (true) {
            int i24 = i23;
            if (i24 >= i20 * i8) {
                break;
            }
            iArr2[i24] = iArr[i24] < i18 / (i5 * i8) ? i : 0;
            if (iArr[i24] == i18 / i4) {
                iArr[i24] = 0;
            }
            i23 = i24 + 1;
        }
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i20, i21);
        for (int i25 = -(i19 / 2); i25 <= i19 / 2; i25++) {
            dArr2[((i19 / 2) + i25) % i20][((i19 / 2) + i25) / i20] = ((a(i25, i19, o, m) * a(i25, d7, i18)) * i18) / i4;
        }
        double d8 = this.kzu;
        if (d8 <= 21.0d) {
            d3 = 0.9222d;
        } else {
            d3 = (d8 - 7.95d) / 14.36d;
        }
        int i26 = i5 * i8;
        int i27 = 1;
        while (true) {
            i9 = i17 * i27;
            if (i9 % 2 == 0) {
                i9--;
            }
            d4 = i4 / 2;
            if ((i26 * d3) / (i9 - 1) < this.kzv) {
                break;
            }
            i27 *= 2;
        }
        double o2 = o(d8);
        double m2 = f.m(o2);
        int i28 = 1;
        while (i28 < i9) {
            i28 *= 2;
        }
        int i29 = i28 * 2;
        double[] dArr3 = new double[i29];
        int i30 = -(i9 / 2);
        while (i30 <= i9 / 2) {
            dArr3[(i9 / 2) + i30] = ((a(i30, i9, o2, m2) * a(i30, d4, i26)) / i29) * 2.0d;
            i30++;
        }
        int[] iArr3 = new int[(int) (2.0d + Math.sqrt(i29))];
        iArr3[0] = 0;
        double[] dArr4 = new double[i29 / 2];
        this.kzt.a(i29, 1, dArr3, iArr3, dArr4);
        cPA();
        int i31 = i29 / 2;
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, i, (i31 / i8) + 1);
        double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, i, i29);
        ByteBuffer allocate = ByteBuffer.allocate((i31 + i21 + 2) * i * i2);
        ByteBuffer allocate2 = ByteBuffer.allocate(((i31 / i8) + 1) * i * i3);
        double[] dArr7 = new double[(i31 + i21 + 2) * i];
        double[] dArr8 = new double[((i31 / i8) + 1) * i];
        int i32 = ((i19 / 2) / (i18 / i4)) + 1;
        int i33 = 0;
        int i34 = (int) ((i9 / 2.0d) / (i26 / i5));
        boolean z3 = true;
        int i35 = i32;
        int i36 = 0;
        int i37 = 0;
        ByteBuffer byteBuffer = allocate;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        while (true) {
            int ceil = (int) (((Math.ceil((i31 * i4) / (i5 * i8)) + 1.0d) + i21) - i35);
            int i41 = ceil + i33 > i6 ? i6 - i33 : ceil;
            byteBuffer.position(0);
            byteBuffer.limit(i41 * i2 * i);
            byte[] bArr = new byte[byteBuffer.limit()];
            int read = inputStream.read(bArr);
            if (read < 0) {
                read = 0;
            }
            if (read < byteBuffer.limit()) {
                i6 = i33 + ((read / i2) * i);
            }
            byteBuffer.limit(read);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.position(read);
            wrap.flip();
            int i42 = read / (i2 * i);
            switch (i2) {
                case 1:
                    i10 = 0;
                    while (i10 < i42 * i) {
                        dArr7[(i * i35) + i10] = 0.007874015748031496d * (wrap.get(i10) - 128.0d);
                        i10++;
                    }
                    break;
                case 2:
                    i10 = 0;
                    while (i10 < i42 * i) {
                        dArr7[(i * i35) + i10] = 3.051850947599719E-5d * wrap.order(this.kzs).asShortBuffer().get(i10);
                        i10++;
                    }
                    break;
                case 3:
                    i10 = 0;
                    while (i10 < i42 * i) {
                        dArr7[(i * i35) + i10] = 1.1920930376163766E-7d * ((wrap.get(i10 * 3) << 0) | (wrap.get((i10 * 3) + 1) << 8) | (wrap.get((i10 * 3) + 2) << 16));
                        i10++;
                    }
                    break;
                case 4:
                    i10 = 0;
                    while (i10 < i42 * i) {
                        dArr7[(i * i35) + i10] = 4.656612875245797E-10d * wrap.order(this.kzs).asIntBuffer().get(i10);
                        i10++;
                    }
                    break;
                default:
                    i10 = i30;
                    break;
            }
            while (i10 < i * ceil) {
                dArr7[(i * i35) + i10] = 0.0d;
                i10++;
            }
            int i43 = i35 + ceil;
            int i44 = i42 + i33;
            boolean z4 = i44 >= i6;
            int i45 = ((((i39 - 1) * i4) + i18) / i18) * i;
            int i46 = 0;
            int i47 = i38;
            int i48 = i36;
            int i49 = i10;
            int i50 = i37;
            while (i46 < i) {
                int i51 = i20 * i8;
                int i52 = i45 + i46;
                switch (i21) {
                    case 7:
                        i15 = i38;
                        for (int i53 = 0; i53 < i31; i53++) {
                            int i54 = iArr[i15];
                            dArr6[i46][i53] = (dArr2[i54][0] * dArr7[(i * 0) + i52]) + (dArr2[i54][1] * dArr7[(i * 1) + i52]) + (dArr2[i54][2] * dArr7[(i * 2) + i52]) + (dArr2[i54][3] * dArr7[(i * 3) + i52]) + (dArr2[i54][4] * dArr7[(i * 4) + i52]) + (dArr2[i54][5] * dArr7[(i * 5) + i52]) + (dArr2[i54][6] * dArr7[(i * 6) + i52]);
                            i52 += iArr2[i15];
                            i15++;
                            if (i15 == i51) {
                                i15 = 0;
                            }
                        }
                        break;
                    case 8:
                    default:
                        i15 = i38;
                        for (int i55 = 0; i55 < i31; i55++) {
                            double d9 = 0.0d;
                            int i56 = iArr[i15];
                            int i57 = i52;
                            for (int i58 = 0; i58 < i21; i58++) {
                                d9 += dArr2[i56][i58] * dArr7[i57];
                                i57 += i;
                            }
                            dArr6[i46][i55] = d9;
                            i52 += iArr2[i15];
                            i15++;
                            if (i15 == i51) {
                                i15 = 0;
                            }
                        }
                        break;
                    case 9:
                        i15 = i38;
                        for (int i59 = 0; i59 < i31; i59++) {
                            int i60 = iArr[i15];
                            dArr6[i46][i59] = (dArr2[i60][0] * dArr7[(i * 0) + i52]) + (dArr2[i60][1] * dArr7[(i * 1) + i52]) + (dArr2[i60][2] * dArr7[(i * 2) + i52]) + (dArr2[i60][3] * dArr7[(i * 3) + i52]) + (dArr2[i60][4] * dArr7[(i * 4) + i52]) + (dArr2[i60][5] * dArr7[(i * 5) + i52]) + (dArr2[i60][6] * dArr7[(i * 6) + i52]) + (dArr2[i60][7] * dArr7[(i * 7) + i52]) + (dArr2[i60][8] * dArr7[(i * 8) + i52]);
                            i52 += iArr2[i15];
                            i15++;
                            if (i15 == i51) {
                                i15 = 0;
                            }
                        }
                        break;
                }
                for (int i61 = i31; i61 < i29; i61++) {
                    dArr6[i46][i61] = 0.0d;
                }
                this.kzt.a(i29, 1, dArr6[i46], iArr3, dArr4);
                dArr6[i46][0] = dArr3[0] * dArr6[i46][0];
                dArr6[i46][1] = dArr3[1] * dArr6[i46][1];
                for (int i62 = 1; i62 < i29 / 2; i62++) {
                    dArr6[i46][i62 * 2] = (dArr3[i62 * 2] * dArr6[i46][i62 * 2]) - (dArr3[(i62 * 2) + 1] * dArr6[i46][(i62 * 2) + 1]);
                    dArr6[i46][(i62 * 2) + 1] = (dArr3[(i62 * 2) + 1] * dArr6[i46][i62 * 2]) + (dArr3[i62 * 2] * dArr6[i46][(i62 * 2) + 1]);
                }
                this.kzt.a(i29, -1, dArr6[i46], iArr3, dArr4);
                int i63 = 0;
                int i64 = i37;
                while (i64 < i31) {
                    dArr8[(i63 * i) + i46] = dArr5[i46][i63] + dArr6[i46][i64];
                    i64 += i8;
                    i63++;
                }
                int i65 = i64 - i31;
                int i66 = 0;
                while (i64 < i29) {
                    dArr5[i46][i66] = dArr6[i46][i64];
                    i64 += i8;
                    i66++;
                }
                i46++;
                i48 = i63;
                i50 = i65;
                i47 = i15;
                i49 = i64;
            }
            int i67 = i39 + (((i4 / gcd) * i31) / i8);
            allocate2.clear();
            if (z) {
                i11 = 0;
                while (i11 < i48 * i) {
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
                        int i68 = 0;
                        int i69 = 0;
                        while (i69 < i48 * i) {
                            if (i7 != 0) {
                                n3 = a(dArr8[i69] * d11, dArr, i7, i68);
                            } else {
                                n3 = n(dArr8[i69] * d11);
                                if (n3 < -128) {
                                    double d12 = n3 / (-128.0d);
                                    if (dArr[0] >= d12) {
                                        d12 = dArr[0];
                                    }
                                    dArr[0] = d12;
                                    n3 = -128;
                                }
                                if (127 < n3) {
                                    double d13 = n3 / 127.0d;
                                    if (dArr[0] >= d13) {
                                        d13 = dArr[0];
                                    }
                                    dArr[0] = d13;
                                    n3 = 127;
                                }
                            }
                            allocate2.put(i69, (byte) (n3 + 128));
                            int i70 = i68 + 1;
                            if (i70 == i) {
                                i70 = 0;
                            }
                            i69++;
                            i68 = i70;
                        }
                        i11 = i69;
                        break;
                    case 2:
                        double d14 = d * 32767.0d;
                        int i71 = 0;
                        int i72 = 0;
                        while (i72 < i48 * i) {
                            if (i7 != 0) {
                                n2 = a(dArr8[i72] * d14, dArr, i7, i71);
                            } else {
                                n2 = n(dArr8[i72] * d14);
                                if (n2 < -32768) {
                                    double d15 = n2 / (-32768.0d);
                                    if (dArr[0] >= d15) {
                                        d15 = dArr[0];
                                    }
                                    dArr[0] = d15;
                                    n2 = -32768;
                                }
                                if (32767 < n2) {
                                    double d16 = n2 / 32767.0d;
                                    if (dArr[0] >= d16) {
                                        d16 = dArr[0];
                                    }
                                    dArr[0] = d16;
                                    n2 = 32767;
                                }
                            }
                            allocate2.order(this.kzs).asShortBuffer().put(i72, (short) n2);
                            int i73 = i71 + 1;
                            if (i73 == i) {
                                i73 = 0;
                            }
                            i72++;
                            i71 = i73;
                        }
                        i11 = i72;
                        break;
                    case 3:
                        double d17 = d * 8388607.0d;
                        int i74 = 0;
                        int i75 = 0;
                        while (i75 < i48 * i) {
                            if (i7 != 0) {
                                n = a(dArr8[i75] * d17, dArr, i7, i74);
                            } else {
                                n = n(dArr8[i75] * d17);
                                if (n < -8388608) {
                                    double d18 = n / (-8388608.0d);
                                    if (dArr[0] >= d18) {
                                        d18 = dArr[0];
                                    }
                                    dArr[0] = d18;
                                    n = -8388608;
                                }
                                if (8388607 < n) {
                                    double d19 = n / 8388607.0d;
                                    if (dArr[0] >= d19) {
                                        d19 = dArr[0];
                                    }
                                    dArr[0] = d19;
                                    n = 8388607;
                                }
                            }
                            allocate2.put(i75 * 3, (byte) (n & 255));
                            int i76 = n >> 8;
                            allocate2.put((i75 * 3) + 1, (byte) (i76 & 255));
                            allocate2.put((i75 * 3) + 2, (byte) ((i76 >> 8) & 255));
                            int i77 = i74 + 1;
                            if (i77 == i) {
                                i77 = 0;
                            }
                            i75++;
                            i74 = i77;
                        }
                        i11 = i75;
                        break;
                    default:
                        i11 = i49;
                        break;
                }
            }
            if (!z3) {
                if (z4) {
                    if (((i44 * i5) / i4) + 2.0d > i40 + i48) {
                        allocate2.position(0);
                        allocate2.limit(i3 * i * i48);
                        a(outputStream, allocate2);
                        i12 = i40 + i48;
                        i13 = i34;
                        z2 = z3;
                    } else {
                        allocate2.position(0);
                        int floor = (int) (i3 * i * ((Math.floor((i44 * i5) / i4) + 2.0d) - i40));
                        if (floor > 0) {
                            allocate2.limit(floor);
                            a(outputStream, allocate2);
                        }
                    }
                } else {
                    allocate2.position(0);
                    allocate2.limit(i3 * i * i48);
                    a(outputStream, allocate2);
                    i12 = i40 + i48;
                    i13 = i34;
                    z2 = z3;
                }
                i14 = (i67 - 1) / (i18 / i4);
                if ($assertionsDisabled && i43 < i14) {
                    throw new AssertionError();
                }
                System.arraycopy(dArr7, i * i14, dArr7, 0, (i43 - i14) * i);
                int i78 = i43 - i14;
                int i79 = i67 - (i14 * (i18 / i4));
                int i80 = i16 + 1;
                if ((i16 & 7) != 7) {
                    q(i44 / i6);
                }
                i40 = i12;
                z3 = z2;
                i16 = i80;
                i34 = i13;
                i33 = i44;
                i38 = i47;
                i35 = i78;
                i30 = i11;
                i39 = i79;
                i37 = i50;
                i36 = i48;
                byteBuffer = wrap;
            } else {
                if (i48 < i34) {
                    i13 = i34 - i48;
                    i12 = i40;
                    z2 = z3;
                } else if (z4) {
                    if (((i44 * i5) / i4) + 2.0d > (i40 + i48) - i34) {
                        allocate2.position(i3 * i * i34);
                        allocate2.limit(i3 * i * i48);
                        a(outputStream, allocate2);
                        i12 = i40 + (i48 - i34);
                        i13 = i34;
                        z2 = z3;
                    } else {
                        allocate2.position(i3 * i * i34);
                        allocate2.limit((int) (i3 * i * ((Math.floor((i44 * i5) / i4) + 2.0d) - i40)));
                        a(outputStream, allocate2);
                    }
                } else {
                    allocate2.position(i3 * i * i34);
                    allocate2.limit(i3 * i * i48);
                    a(outputStream, allocate2);
                    i12 = i40 + (i48 - i34);
                    i13 = i34;
                    z2 = false;
                }
                i14 = (i67 - 1) / (i18 / i4);
                if ($assertionsDisabled) {
                }
                System.arraycopy(dArr7, i * i14, dArr7, 0, (i43 - i14) * i);
                int i782 = i43 - i14;
                int i792 = i67 - (i14 * (i18 / i4));
                int i802 = i16 + 1;
                if ((i16 & 7) != 7) {
                }
                i40 = i12;
                z3 = z2;
                i16 = i802;
                i34 = i13;
                i33 = i44;
                i38 = i47;
                i35 = i782;
                i30 = i11;
                i39 = i792;
                i37 = i50;
                i36 = i48;
                byteBuffer = wrap;
            }
        }
        q(1.0d);
        return dArr[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:251:0x08a4, code lost:
        q(1.0d);
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
        int n;
        int n2;
        int n3;
        boolean z2;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        double[] dArr2 = {0.0d};
        int i20 = this.kzw;
        double d5 = this.kzu;
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
            if (d6 < this.kzv) {
                break;
            }
            i22 *= 2;
        }
        double o = o(d5);
        double m = f.m(o);
        int i23 = 1;
        while (i23 < i9) {
            i23 *= 2;
        }
        int i24 = i23 * 2;
        double[] dArr3 = new double[i24];
        int i25 = -(i9 / 2);
        while (i25 <= i9 / 2) {
            dArr3[i25 + (i9 / 2)] = ((((a(i25, i9, o, m) * a(i25, d3, i21)) * i21) / i4) / i24) * 2.0d;
            i25++;
        }
        int[] iArr3 = new int[(int) (2.0d + Math.sqrt(i24))];
        iArr3[0] = 0;
        double[] dArr4 = new double[i24 / 2];
        this.kzt.a(i24, 1, dArr3, iArr3, dArr4);
        if (i8 == 1) {
            int i26 = (i4 / gcd) * i5;
            double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, 1, 1);
            dArr5[0][0] = 1.0d;
            iArr = new int[]{i4 / i5};
            iArr2 = new int[]{0};
            i12 = 1;
            i10 = 1;
            dArr = dArr5;
            i11 = i26;
            i13 = 1;
        } else {
            double d7 = this.kzu;
            int i27 = (i4 / gcd) * i5;
            double d8 = (((i21 / 2) - (i4 / 2)) * 2) / 2.0d;
            double d9 = (i4 / 2) + (((i21 / 2) - (i4 / 2)) / 2.0d);
            if (d7 <= 21.0d) {
                d4 = 0.9222d;
            } else {
                d4 = (d7 - 7.95d) / 14.36d;
            }
            int i28 = (int) ((d4 * (i27 / d8)) + 1.0d);
            if (i28 % 2 == 0) {
                i28++;
            }
            double o2 = o(d7);
            double m2 = f.m(o2);
            int i29 = i27 / i21;
            int i30 = (i28 / i29) + 1;
            int[] iArr4 = new int[i29];
            for (int i31 = 0; i31 < i29; i31++) {
                iArr4[i31] = (i27 / i21) - (((i27 / i5) * i31) % (i27 / i21));
                if (iArr4[i31] == i27 / i21) {
                    iArr4[i31] = 0;
                }
            }
            int[] iArr5 = new int[i29];
            int i32 = 0;
            while (true) {
                int i33 = i32;
                if (i33 >= i29) {
                    break;
                }
                iArr5[i33] = (((i27 / i5) - iArr4[i33]) / (i27 / i21)) + 1;
                if (iArr4[i33 + 1 == i29 ? 0 : i33 + 1] == 0) {
                    iArr5[i33] = iArr5[i33] - 1;
                }
                i32 = i33 + 1;
            }
            double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, i29, i30);
            int i34 = -(i28 / 2);
            while (i34 <= i28 / 2) {
                dArr6[((i28 / 2) + i34) % i29][((i28 / 2) + i34) / i29] = ((a(i34, i28, o2, m2) * a(i34, d9, i27)) * i27) / i21;
                i34++;
            }
            i25 = i34;
            iArr = iArr5;
            iArr2 = iArr4;
            i10 = i30;
            dArr = dArr6;
            i11 = i27;
            i12 = i29;
            i13 = i28;
        }
        cPA();
        int i35 = i24 / 2;
        double[][] dArr7 = (double[][]) Array.newInstance(Double.TYPE, i, i24);
        double[][] dArr8 = (double[][]) Array.newInstance(Double.TYPE, i, i10 + 1 + i35);
        ByteBuffer allocate = ByteBuffer.allocate(((i35 / i8) + i8 + 1) * i * i2);
        ByteBuffer allocate2 = ByteBuffer.allocate((int) ((((i35 * i5) / i4) + 1.0d) * i3 * i));
        double[] dArr9 = new double[((i35 / i8) + i8 + 1) * i];
        double[] dArr10 = new double[(int) (i * (((i35 * i5) / i4) + 1.0d))];
        int i36 = 0;
        int i37 = 0;
        boolean z3 = true;
        int i38 = (int) (((i13 / 2.0d) / (i11 / i5)) + ((i9 / 2.0d) / (i21 / i5)));
        int i39 = 0;
        int i40 = 0;
        int i41 = 0;
        int i42 = 0;
        int i43 = i25;
        ByteBuffer byteBuffer = allocate;
        int i44 = i38;
        int i45 = 0;
        while (true) {
            int i46 = (((i35 - 0) - 1) / i8) + 1;
            if (i46 + i45 > i6) {
                i46 = i6 - i45;
            }
            byteBuffer.position(0);
            byteBuffer.limit(i2 * i * i46);
            byte[] bArr = new byte[byteBuffer.limit()];
            int read = inputStream.read(bArr);
            if (read < 0) {
                read = 0;
            }
            if (read < byteBuffer.limit()) {
                i6 = i45 + ((read / i2) * i);
            }
            byteBuffer.limit(read);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.position(read);
            wrap.flip();
            int i47 = read / (i2 * i);
            switch (i2) {
                case 1:
                    i43 = 0;
                    while (i43 < i47 * i) {
                        dArr9[(i * 0) + i43] = 0.007874015748031496d * ((wrap.get(i43) & 255) - 128);
                        i43++;
                    }
                    break;
                case 2:
                    i43 = 0;
                    while (i43 < i47 * i) {
                        dArr9[(i * 0) + i43] = 3.051850947599719E-5d * wrap.order(this.kzs).asShortBuffer().get(i43);
                        i43++;
                    }
                    break;
                case 3:
                    i43 = 0;
                    while (i43 < i47 * i) {
                        dArr9[(i * 0) + i43] = 1.1920930376163766E-7d * (((wrap.get(i43 * 3) & 255) << 0) | ((wrap.get((i43 * 3) + 1) & 255) << 8) | ((wrap.get((i43 * 3) + 2) & 255) << 16));
                        i43++;
                    }
                    break;
                case 4:
                    i43 = 0;
                    while (i43 < i47 * i) {
                        dArr9[(i * 0) + i43] = 4.656612875245797E-10d * wrap.order(this.kzs).getInt(i43);
                        i43++;
                    }
                    break;
            }
            while (i43 < i * i46) {
                dArr9[i43] = 0.0d;
                i43++;
            }
            int i48 = i45 + i47;
            boolean z4 = inputStream.available() < 0 || i48 >= i6;
            int i49 = 0;
            int i50 = i36;
            int i51 = i40;
            int i52 = i41;
            while (true) {
                int i53 = i43;
                if (i49 < i) {
                    int i54 = 0;
                    int i55 = 0;
                    while (i55 < i35) {
                        if (!$assertionsDisabled && i54 >= (((i35 - 0) - 1) / i8) + 1) {
                            throw new AssertionError();
                        }
                        dArr7[i49][i55] = dArr9[(i54 * i) + i49];
                        for (int i56 = i55 + 1; i56 < i55 + i8; i56++) {
                            dArr7[i49][i56] = 0.0d;
                        }
                        i55 += i8;
                        i54++;
                    }
                    if (!$assertionsDisabled && i54 != (((i35 - 0) - 1) / i8) + 1) {
                        throw new AssertionError();
                    }
                    for (int i57 = i35; i57 < i24; i57++) {
                        dArr7[i49][i57] = 0.0d;
                    }
                    int i58 = i55 - i35;
                    int i59 = i52 + i54;
                    this.kzt.a(i24, 1, dArr7[i49], iArr3, dArr4);
                    dArr7[i49][0] = dArr3[0] * dArr7[i49][0];
                    dArr7[i49][1] = dArr3[1] * dArr7[i49][1];
                    for (int i60 = 1; i60 < i35; i60++) {
                        double d10 = (dArr3[i60 * 2] * dArr7[i49][i60 * 2]) - (dArr3[(i60 * 2) + 1] * dArr7[i49][(i60 * 2) + 1]);
                        double d11 = (dArr3[(i60 * 2) + 1] * dArr7[i49][i60 * 2]) + (dArr3[i60 * 2] * dArr7[i49][(i60 * 2) + 1]);
                        dArr7[i49][i60 * 2] = d10;
                        dArr7[i49][(i60 * 2) + 1] = d11;
                    }
                    this.kzt.a(i24, -1, dArr7[i49], iArr3, dArr4);
                    int i61 = 0;
                    while (i61 < i35) {
                        double[] dArr11 = dArr8[i49];
                        int i62 = i10 + 1 + i61;
                        dArr11[i62] = dArr11[i62] + dArr7[i49][i61];
                        i61++;
                    }
                    int i63 = i37 / (i11 / i21);
                    if (i37 % (i11 / i21) != 0) {
                        i63++;
                    }
                    i43 = i61;
                    int length = (dArr8[0].length * i49) + i63;
                    int i64 = 0;
                    int i65 = i36;
                    while (length - (dArr8[0].length * i49) < i35 + 1) {
                        int i66 = iArr2[i65];
                        int i67 = iArr[i65] + length;
                        i65++;
                        if (i65 == i12) {
                            i65 = 0;
                        }
                        if (!$assertionsDisabled && ((length - (dArr8[0].length * i49)) * (i11 / i21)) - (((i11 / i5) * i64) + i37) != i66) {
                            throw new AssertionError();
                        }
                        int i68 = length;
                        int i69 = 0;
                        double d12 = 0.0d;
                        int i70 = i68;
                        while (i69 < i10) {
                            d12 += dArr[i66][i69] * dArr8[i70 / dArr8[0].length][i70 % dArr8[0].length];
                            i70++;
                            i69++;
                        }
                        dArr10[(i64 * i) + 0 + i49] = d12;
                        i64++;
                        i43 = i69;
                        length = i67;
                    }
                    i49++;
                    i50 = i65;
                    i51 = i64;
                    i52 = i59;
                } else {
                    int i71 = i37 + ((i11 / i5) * i51);
                    allocate2.clear();
                    if (z) {
                        i14 = 0;
                        while (i14 < i51 * i) {
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
                                int i72 = 0;
                                int i73 = 0;
                                while (i73 < i51 * i) {
                                    if (i7 != 0) {
                                        n3 = a(dArr10[i73] * d14, dArr2, i7, i72);
                                    } else {
                                        n3 = n(dArr10[i73] * d14);
                                        if (n3 < -128) {
                                            double d15 = n3 / (-128.0d);
                                            if (dArr2[0] >= d15) {
                                                d15 = dArr2[0];
                                            }
                                            dArr2[0] = d15;
                                            n3 = -128;
                                        }
                                        if (127 < n3) {
                                            double d16 = n3 / 127.0d;
                                            if (dArr2[0] >= d16) {
                                                d16 = dArr2[0];
                                            }
                                            dArr2[0] = d16;
                                            n3 = 127;
                                        }
                                    }
                                    allocate2.put(i73, (byte) (n3 + 128));
                                    int i74 = i72 + 1;
                                    if (i74 == i) {
                                        i74 = 0;
                                    }
                                    i73++;
                                    i72 = i74;
                                }
                                i14 = i73;
                                break;
                            case 2:
                                double d17 = d * 32767.0d;
                                int i75 = 0;
                                int i76 = 0;
                                while (i76 < i51 * i) {
                                    if (i7 != 0) {
                                        n2 = a(dArr10[i76] * d17, dArr2, i7, i75);
                                    } else {
                                        n2 = n(dArr10[i76] * d17);
                                        if (n2 < -32768) {
                                            double d18 = n2 / (-32768.0d);
                                            if (dArr2[0] >= d18) {
                                                d18 = dArr2[0];
                                            }
                                            dArr2[0] = d18;
                                            n2 = -32768;
                                        }
                                        if (32767 < n2) {
                                            double d19 = n2 / 32767.0d;
                                            if (dArr2[0] >= d19) {
                                                d19 = dArr2[0];
                                            }
                                            dArr2[0] = d19;
                                            n2 = 32767;
                                        }
                                    }
                                    allocate2.order(this.kzs).asShortBuffer().put(i76, (short) n2);
                                    int i77 = i75 + 1;
                                    if (i77 == i) {
                                        i77 = 0;
                                    }
                                    i76++;
                                    i75 = i77;
                                }
                                i14 = i76;
                                break;
                            case 3:
                                double d20 = d * 8388607.0d;
                                int i78 = 0;
                                int i79 = 0;
                                while (i79 < i51 * i) {
                                    if (i7 != 0) {
                                        n = a(dArr10[i79] * d20, dArr2, i7, i78);
                                    } else {
                                        n = n(dArr10[i79] * d20);
                                        if (n < -8388608) {
                                            double d21 = n / (-8388608.0d);
                                            if (dArr2[0] >= d21) {
                                                d21 = dArr2[0];
                                            }
                                            dArr2[0] = d21;
                                            n = -8388608;
                                        }
                                        if (8388607 < n) {
                                            double d22 = n / 8388607.0d;
                                            if (dArr2[0] >= d22) {
                                                d22 = dArr2[0];
                                            }
                                            dArr2[0] = d22;
                                            n = 8388607;
                                        }
                                    }
                                    allocate2.put(i79 * 3, (byte) (n & 255));
                                    int i80 = n >> 8;
                                    allocate2.put((i79 * 3) + 1, (byte) (i80 & 255));
                                    allocate2.put((i79 * 3) + 2, (byte) ((i80 >> 8) & 255));
                                    int i81 = i78 + 1;
                                    if (i81 == i) {
                                        i81 = 0;
                                    }
                                    i79++;
                                    i78 = i81;
                                }
                                i14 = i79;
                                break;
                            default:
                                i14 = i53;
                                break;
                        }
                    }
                    if (!z3) {
                        if (z4) {
                            if (((i48 * i5) / i4) + 2.0d > i39 + i51) {
                                allocate2.position(0);
                                allocate2.limit(i3 * i * i51);
                                a(outputStream, allocate2);
                                i15 = i39 + i51;
                                z2 = z3;
                                i16 = i44;
                            } else {
                                allocate2.position(0);
                                int floor = (int) (i3 * i * ((Math.floor((i48 * i5) / i4) + 2.0d) - i39));
                                if (floor > 0) {
                                    allocate2.limit(floor);
                                    a(outputStream, allocate2);
                                }
                            }
                        } else {
                            allocate2.position(0);
                            allocate2.limit(i3 * i * i51);
                            a(outputStream, allocate2);
                            i15 = i39 + i51;
                            z2 = z3;
                            i16 = i44;
                        }
                        i17 = (i71 - 1) / (i11 / i21);
                        if (i17 > i35) {
                            i17 = i35;
                        }
                        for (i18 = 0; i18 < i; i18++) {
                            System.arraycopy(dArr8[i18], i17, dArr8[i18], 0, ((i10 + 1) + i35) - i17);
                        }
                        int i82 = i71 - (i17 * (i11 / i21));
                        for (i19 = 0; i19 < i; i19++) {
                            System.arraycopy(dArr7[i19], i35, dArr8[i19], i10 + 1, i35);
                        }
                        int i83 = i42 + 1;
                        if ((i42 & 7) != 7) {
                            q(i48 / i6);
                        }
                        i44 = i16;
                        i39 = i15;
                        z3 = z2;
                        i42 = i83;
                        i36 = i50;
                        i40 = i51;
                        i41 = i52;
                        i45 = i48;
                        byteBuffer = wrap;
                        int i84 = i14;
                        i37 = i82;
                        i43 = i84;
                    } else {
                        if (i51 < i44) {
                            i16 = i44 - i51;
                            i15 = i39;
                            z2 = z3;
                        } else if (z4) {
                            if (((i48 * i5) / i4) + 2.0d > (i39 + i51) - i44) {
                                allocate2.position(i3 * i * i44);
                                allocate2.limit(i3 * i * (i51 - i44));
                                a(outputStream, allocate2);
                                i15 = (i51 - i44) + i39;
                                z2 = z3;
                                i16 = i44;
                            } else {
                                allocate2.position(i3 * i * i44);
                                allocate2.limit((int) (i3 * i * ((((Math.floor((i48 * i5) / i4) + 2.0d) + i39) + i51) - i44)));
                                a(outputStream, allocate2);
                            }
                        } else {
                            allocate2.position(i3 * i * i44);
                            allocate2.limit(i3 * i * i51);
                            a(outputStream, allocate2);
                            z2 = false;
                            i15 = (i51 - i44) + i39;
                            i16 = i44;
                        }
                        i17 = (i71 - 1) / (i11 / i21);
                        if (i17 > i35) {
                        }
                        while (i18 < i) {
                        }
                        int i822 = i71 - (i17 * (i11 / i21));
                        while (i19 < i) {
                        }
                        int i832 = i42 + 1;
                        if ((i42 & 7) != 7) {
                        }
                        i44 = i16;
                        i39 = i15;
                        z3 = z2;
                        i42 = i832;
                        i36 = i50;
                        i40 = i51;
                        i41 = i52;
                        i45 = i48;
                        byteBuffer = wrap;
                        int i842 = i14;
                        i37 = i822;
                        i43 = i842;
                    }
                }
            }
        }
    }

    public double a(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, double d, int i4, boolean z, int i5) throws IOException {
        ByteBuffer byteBuffer;
        double[] dArr = {0.0d};
        int i6 = 0;
        cPA();
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
                    d2 = wrap2.order(this.kzs).asShortBuffer().get(0) * 3.051850947599719E-5d;
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
                    d2 = wrap4.order(this.kzs).asIntBuffer().get(0) * 4.656612875245797E-10d;
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
                            int a = i5 != 0 ? a(d4, dArr, i5, i6) : n(d4);
                            byteBuffer.position(0);
                            byteBuffer.limit(1);
                            byteBuffer.put(0, (byte) (a + 128));
                            byteBuffer.flip();
                            a(outputStream, byteBuffer);
                            break;
                        case 2:
                            double d5 = 32767.0d * d3;
                            int a2 = i5 != 0 ? a(d5, dArr, i5, i6) : n(d5);
                            byteBuffer.position(0);
                            byteBuffer.limit(2);
                            byteBuffer.asShortBuffer().put(0, (short) a2);
                            byteBuffer.flip();
                            a(outputStream, byteBuffer);
                            break;
                        case 3:
                            double d6 = 8388607.0d * d3;
                            int a3 = i5 != 0 ? a(d6, dArr, i5, i6) : n(d6);
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
                    q(i10 / (i4 * i));
                }
                i7 = i10;
                i6 = i9;
                allocate = byteBuffer;
            } else {
                q(1.0d);
                return dArr[0];
            }
        }
        q(1.0d);
        return dArr[0];
    }

    public j() {
        this.kzs = ByteOrder.LITTLE_ENDIAN;
        this.kzt = new k();
        this.kzu = 150.0d;
        this.kzv = 200.0d;
        this.kzw = 1;
        this.kzI = false;
    }

    public j(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, int i6, double d, int i7, boolean z) throws Exception {
        int i8;
        int i9;
        this.kzs = ByteOrder.LITTLE_ENDIAN;
        this.kzt = new k();
        this.kzu = 150.0d;
        this.kzv = 200.0d;
        this.kzw = 1;
        this.kzI = false;
        double[] dArr = {0.0d};
        if (i7 < 0 || i7 > 4) {
            throw new IllegalArgumentException("unrecognized dither type : " + i7);
        }
        this.kzI = z;
        if (!this.kzI) {
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
        if (!this.kzI) {
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
                i12 = Integer.MAX_VALUE;
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
        if (!this.kzI) {
            System.err.printf("\n", new Object[0]);
        }
        if (i9 != 0) {
            Dx(i5);
        }
        if (dArr[0] > 1.0d && !this.kzI) {
            System.err.printf("clipping detected : %gdB\n", Double.valueOf(20.0d * Math.log10(dArr[0])));
        }
    }

    protected byte[] g(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.limit() - byteBuffer.position()];
        byteBuffer.get(bArr, 0, bArr.length);
        return bArr;
    }

    protected void a(OutputStream outputStream, ByteBuffer byteBuffer) {
        try {
            outputStream.write(g(byteBuffer));
        } catch (IOException e) {
        }
    }
}
